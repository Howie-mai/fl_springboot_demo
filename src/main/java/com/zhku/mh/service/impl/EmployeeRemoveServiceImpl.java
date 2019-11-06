package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmployeeRemoveDao;
import com.zhku.mh.entities.EmployeeRemove;
import com.zhku.mh.entities.EmployeeRemoveExample;
import com.zhku.mh.service.EmployeeRemoveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRemoveServiceImpl extends AbstractServiceImpl<EmployeeRemove, EmployeeRemoveExample, Integer> implements EmployeeRemoveService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRemoveServiceImpl.class);

    @Autowired
    public void setBaseDao(EmployeeRemoveDao dao) {
        this.baseDao = dao;
    }
}