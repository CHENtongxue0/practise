package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/depts")
public class DeptController {

    private DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public Result findAll() {
        List<Dept> deptList = deptService.fillAll();
        return  Result.success(deptList);


    }
    @DeleteMapping
    public Result deleteById(Integer id){
       deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public  Result add(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id){
        //调用业务层根据id获取部门对象
        Dept dept = deptService.getById(id);

        //将部门对象返回
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.updateById(dept);
        return Result.success();
    }

    }

