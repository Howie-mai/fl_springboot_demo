package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.HrRoleDao;
import com.zhku.mh.entities.HrRole;
import com.zhku.mh.entities.HrRoleExample;
import com.zhku.mh.service.HrRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrRoleServiceImpl extends AbstractServiceImpl<HrRole, HrRoleExample, Integer> implements HrRoleService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(HrRoleServiceImpl.class);

    @Autowired
    public void setBaseDao(HrRoleDao dao) {
        this.baseDao = dao;
    }
}