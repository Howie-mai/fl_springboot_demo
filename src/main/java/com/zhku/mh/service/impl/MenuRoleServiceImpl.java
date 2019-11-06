package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.MenuRoleDao;
import com.zhku.mh.entities.MenuRole;
import com.zhku.mh.entities.MenuRoleExample;
import com.zhku.mh.service.MenuRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuRoleServiceImpl extends AbstractServiceImpl<MenuRole, MenuRoleExample, Integer> implements MenuRoleService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(MenuRoleServiceImpl.class);

    @Autowired
    public void setBaseDao(MenuRoleDao dao) {
        this.baseDao = dao;
    }
}