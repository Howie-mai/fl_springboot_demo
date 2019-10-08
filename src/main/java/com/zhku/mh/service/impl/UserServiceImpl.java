package com.zhku.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhku.mh.dao.UserDao;
import com.zhku.mh.entities.User;
import com.zhku.mh.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-08 14:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userDao.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public Integer save(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public Integer update(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer del(Integer id) {
        return userDao.delUser(id);
    }
}
