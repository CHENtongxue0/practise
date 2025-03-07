package com.itheima.HelloController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(String name){
        System.out.println("来到了服务器");
       return "hello heima"+name;
    }
}
