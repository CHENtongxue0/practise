package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DeptMapperTest {
    @Autowired
    private DeptMapper deptMapper;
    @Test
    public void testFindAll(){
      List<Dept> deptList =deptMapper.findAll();
        deptList.forEach(dept->{
            System.out.println(dept);
        });
    }


}
