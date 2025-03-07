package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    Long getCount(String name , Integer gender, LocalDate begin,  LocalDate end );
    List<Emp> getByPageList(String name, Integer gender,
                            LocalDate begin, LocalDate end, Integer start, Integer length);

    Page<Emp> findByPage(String name, Integer gender,
                         LocalDate begin, LocalDate end);

    void insert(Emp emp);
}
