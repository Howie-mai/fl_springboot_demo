package com.zhku.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.UserDao;
import com.zhku.mh.entities.User;
import com.zhku.mh.entities.UserExample;
import com.zhku.mh.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserExample, Integer> implements UserService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public void setBaseDao(UserDao dao) {
        this.baseDao = dao;
    }

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> getList(Integer pageNum, Integer pageSize, String keywords) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        if (StringUtils.isNotBlank(keywords)) {
            example.createCriteria().andNameLike("%" + keywords + "%");
        }
        List<User> dataList = baseDao.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(dataList);
        return pageInfo;
    }

    @Override
    public int UpdateList(List<User> UserList) {
        return userDao.updateList(UserList);

    }

    @Override
    public int InsertList(List<User> UserList) {
        return userDao.insertList(UserList);

    }
}
