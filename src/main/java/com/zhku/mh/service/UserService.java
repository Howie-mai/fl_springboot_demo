package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.entities.User;

import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-08 14:22
 */
public interface UserService {

    PageInfo<User> getList(Integer pageSize, Integer pageNum);

    User getUser(Integer id);

    Integer save(User user);

    Integer update(User user);

    Integer del(Integer id);
}
