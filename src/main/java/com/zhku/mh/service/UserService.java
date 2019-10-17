package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.User;
import com.zhku.mh.entities.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends BaseService<User, UserExample, Integer> {
    PageInfo<User> getList(Integer pageNum, Integer pageSize, String keywords);

    int UpdateList(List<User> UserList);
}
