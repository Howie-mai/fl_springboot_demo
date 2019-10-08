package com.zhku.mh.controller;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.entities.User;
import com.zhku.mh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-09-24 10:10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public PageInfo<User> list(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
        return userService.getList(pageSize,pageNum);
    }

    @RequestMapping("/get/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping("/save")
    public Integer get(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping("/update")
    public Integer update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping("/del/{id}")
    public Integer del(@PathVariable Integer id) {
        return userService.del(id);
    }
}
