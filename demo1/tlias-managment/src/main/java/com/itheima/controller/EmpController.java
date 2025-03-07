package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @Description EmpController
 * @Author songyu
 * @Date 2024-12-30  16:45
 */
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 处理分页查询员工请求
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @param page
     * @param pageSize
     * @return
     *
     * @RequestParam(defaultValue = "1") 设置指定参数的默认值，如果前端没有传递那么久采用默认值
     *  @DateTimeFormat(pattern = "yyyy-MM-dd") 用于接收指定格式数据封装给LocalDate或LocalDateTime
     */
    @GetMapping
    public Result getByPage(
            String name,
            Integer gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10")Integer pageSize
    ){
        //调用业务获取分页数据 PageBean
//        PageBean pageBean = empService.getByPage(name, gender, begin, end, page, pageSize);
        PageBean pageBean = empService.getByPage2(name, gender, begin, end, page, pageSize);

        //返回数据
        return Result.success(pageBean);



    }
    @PostMapping
    public Result add(@RequestBody Emp emp){

        //调用业务新增员工
        empService.addEmp(emp);

        //返回数据
        return Result.success();
    }


}