package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//todo
//fixme

@Data
@NoArgsConstructor //lombok  无参
@AllArgsConstructor//全参
@Builder
public class Dept {
    private Integer id;//int类型不能为null
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static void main(String[] args) {
        Dept dept = new Dept(1, "heima", LocalDateTime.now(), LocalDateTime.now());
        dept.setName("李四");
        System.out.println(dept);
    }

}
