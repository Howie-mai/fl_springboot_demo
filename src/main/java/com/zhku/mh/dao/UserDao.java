package com.zhku.mh.dao;

import com.zhku.mh.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-08 14:23
 */
@Mapper
public interface UserDao {
    List<User> queryUserList();

    User getUser(@Param("id") Integer id);

    Integer saveUser(User user);

    Integer updateUser(User user);

    Integer delUser(@Param("id") Integer id);
}
