package com.zhku.mh;

import com.zhku.mh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.zhku.mh.dao")
public class SpringbootDemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void tse(){
        System.out.println(userService.getList(1,"张三"));
        System.out.println(userService.getList(0,"张三"));
        System.out.println(userService.getList(1," "));
    }
}
