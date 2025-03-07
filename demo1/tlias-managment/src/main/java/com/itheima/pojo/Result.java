package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private  Integer code;//代表处理成功或失败的状态码，1代表成功，0代表失败

    private  String msg;
    private  Object data;
    //定义工具方法，便于封装返回成功数据和失败数据
    //static 代表静态的，这里是静态方法，调用静态方法语法： 类名.静态方法名(参数)
    public static Result success(){
        return new Result(1,"success",null);
    }
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    public static Result error(String msg){
        return new Result(0,msg,null);
    }

}
