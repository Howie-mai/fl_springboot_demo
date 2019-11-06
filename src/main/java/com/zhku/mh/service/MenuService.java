package com.zhku.mh.service;

import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.MenuDTO;
import com.zhku.mh.entities.Menu;
import com.zhku.mh.entities.MenuExample;

import java.util.List;

public interface MenuService extends BaseService<Menu, MenuExample, Integer> {
    List<MenuDTO> getAllMenu();

    List<MenuDTO> getMenusByHrId(Integer hrId);
}