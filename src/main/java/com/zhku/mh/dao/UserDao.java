package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.User;
import com.zhku.mh.entities.UserExample;
import org.apache.ibatis.annotations.Mapper;

public interface UserDao extends BaseDao<User, UserExample, Integer> {
}
