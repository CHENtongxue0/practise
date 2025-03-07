package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
//    @Override
//    public PageBean getByPage(String name, Integer gander, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
//        //定义返回对象
//        PageBean pageBean = new PageBean();
//
//        //调用mapper获取总条数
//        Long total =empMapper.getCount(name,gander,begin,end);
//        //调用mapper获取当前页数据列表
//        Integer start=(page -1 )*pageSize;
//        Integer length=pageSize;
//        List <Emp> empList= empMapper.getByPageList(name,gander,begin,end,start,length);
//
//        //将上面获取的值封装给PageBean对象
//        pageBean.setRows(empList);
//        pageBean.setTotal(total);
//
//        return pageBean;
//
//    }

    @Override
    public PageBean getByPage2(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        // 1.设置 PageHelper 告诉查询第几页和每页显示多少条
        PageHelper.startPage(page, pageSize);//传进去的目的是计算start和length

        // 2.执行开发人员的sql语句（底层会执行提起操作优化的2条sql语句），返回PageHelper封装的Page对象（总条数和当前页数据列表）
        Page<Emp> pageInfo = empMapper.findByPage(name, gender, begin, end);
        long total = pageInfo.getTotal();//总条数
        List<Emp> empList = pageInfo.getResult();//当前页数据列表

        // 3.将Page对象封装成PageBean对象
        return new PageBean(total,empList);
    }
    @Transactional
    @Override
    public void addEmp(Emp emp) {
        //1.添加员工数据到数据库
        //补全数据-password，默认密码123456
        emp.setPassword("123456");
        //补全数据-createTime
        emp.setCreateTime(LocalDateTime.now());
        //补全数据-updateTime
        emp.setUpdateTime(LocalDateTime.now());

        //调用mapper插入数据库，需要封装emp里面的id值（插入数据返回自增长主键值）
        empMapper.insert(emp);//插入后 emp.getId()是有值的（自增长主键值）

        //2.添加员工的工作经历列表到数据库
        //判断是否含有员工的工作经历，如果有才新增, emp.getExprList().size()获取工作经历对象的个数
        if(emp.getExprList()!=null && emp.getExprList().size()>0) {

            //补全数据-所属员工id
            emp.getExprList().forEach(empObj->empObj.setEmpId(emp.getId()));
            //调用mapper批量插入数据库
            empExprMapper.batchInsert(emp.getExprList());
    }
}
}
