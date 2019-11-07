package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.User;
import com.zhku.mh.entities.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseDao<User, UserExample, Integer> {
    int updateList(@Param("list") List<User> UserList);

    int insertList(@Param("list") List<User> UserList);
}
