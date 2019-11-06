package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.entities.HrExample;
import com.zhku.mh.entities.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrDao extends BaseDao<Hr, HrExample, Integer> {
    List<Role> getRolesByHrId(@Param("id") Integer id);
}