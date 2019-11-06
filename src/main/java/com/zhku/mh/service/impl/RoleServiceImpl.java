package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.RoleDao;
import com.zhku.mh.entities.Role;
import com.zhku.mh.entities.RoleExample;
import com.zhku.mh.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role, RoleExample, Integer> implements RoleService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    public void setBaseDao(RoleDao dao) {
        this.baseDao = dao;
    }
}