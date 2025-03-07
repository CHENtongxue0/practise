package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmpMapperTest {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testPage(){

        //查询员工，查询第1页，每页5条
        //查询总条数
        Long count = empMapper.getCount(null, null, null, null);
        System.out.println("总条数："+count);

        //获取第一页数据列表
        Integer start = (1-1)*5;
        Integer length = 5;
        List<Emp> empList = empMapper.getByPageList(null, null,
                null, null, start, length);
        System.out.println("第一页数据列表：");
        empList.forEach(emp->System.out.println(emp));//遍历每个元素进行打印

        //获取第二页数据列表
        start = (2-1)*5;
        length = 5;
        empList = empMapper.getByPageList(null, null,
                null, null, start, length);
        System.out.println("第二页数据列表：");
        empList.forEach(emp->System.out.println(emp));//遍历每个元素进行打印
    }
}