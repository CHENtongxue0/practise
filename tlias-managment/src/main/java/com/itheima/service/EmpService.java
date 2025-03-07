package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {


//PageBean getByPage(String name, Integer gander,
//                   LocalDate begin,LocalDate end, Integer page,
//                   Integer pageSize);


   PageBean getByPage2(String name, Integer gender,
                        LocalDate begin, LocalDate end,
                        Integer page,Integer pageSize);

    void addEmp(Emp emp);

}



