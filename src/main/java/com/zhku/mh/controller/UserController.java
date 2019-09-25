package com.zhku.mh.controller;

import com.zhku.mh.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-09-24 10:10
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public List<User> get() {

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("李四");

        User user1 = new User();
        user1.setId(2);
        user1.setName("张三");

        list.add(user);
        list.add(user1);

        return list;
    }
}
