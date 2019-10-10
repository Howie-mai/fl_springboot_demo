package com.zhku.mh.controller;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.entities.User;
import com.zhku.mh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = " ") String keywords) {
        return userService.getList(pageNum,pageSize,keywords);
    }

    @RequestMapping("/get/{id}")
    public User get(@PathVariable Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping("/save")
    public Integer get(@RequestBody User user) {
        return userService.insertSelective(user);
    }

    @RequestMapping("/update")
    public Integer update(@RequestBody User user){
        return userService.updateByPrimaryKey(user);
    }

    @RequestMapping("/del/{id}")
    public Integer del(@PathVariable Integer id) {
        return userService.deleteByPrimaryKey(id);
    }
}
