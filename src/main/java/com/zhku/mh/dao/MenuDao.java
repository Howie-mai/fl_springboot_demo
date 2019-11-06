package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.DTO.MenuDTO;
import com.zhku.mh.entities.Menu;
import com.zhku.mh.entities.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao extends BaseDao<Menu, MenuExample, Integer> {
    List<MenuDTO> getAllMenu();

    List<MenuDTO> getMenusByHrId(@Param("hrId") Integer hrId);
}