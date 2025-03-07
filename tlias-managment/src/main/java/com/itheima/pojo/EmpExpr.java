package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   // get and set
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
    private  Integer id;
    private  Integer empId;
    private LocalDate begin;
    private LocalDate end;
    private String company;
    private  String job;

}
