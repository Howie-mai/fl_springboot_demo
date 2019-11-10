package com.zhku.mh;

import com.zhku.mh.entities.User;
import com.zhku.mh.service.EmployeeService;
import com.zhku.mh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.zhku.mh.dao")
public class SpringbootDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void contextLoads() {
        System.out.println(employeeService.getAllEmpDto());
    }

    @Test
    public void tse(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode("123456");
        System.out.println(encodedPassword);
    }
}
