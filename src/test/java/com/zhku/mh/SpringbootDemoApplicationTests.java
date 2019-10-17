package com.zhku.mh;

import com.zhku.mh.entities.User;
import com.zhku.mh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        List<User> dataList = new ArrayList<>();
        User user = new User();
        user.setName("张三1");
        user.setId(1);
        dataList.add(user);

        User user1 = new User();
        user1.setName("张三1");
        user1.setId(1);
        dataList.add(user1);
        System.out.println(userService.UpdateList(dataList));
    }
}
