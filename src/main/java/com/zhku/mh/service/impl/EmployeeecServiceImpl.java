package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmployeeecDao;
import com.zhku.mh.entities.Employeeec;
import com.zhku.mh.entities.EmployeeecExample;
import com.zhku.mh.service.EmployeeecService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeecServiceImpl extends AbstractServiceImpl<Employeeec, EmployeeecExample, Integer> implements EmployeeecService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployeeecServiceImpl.class);

    @Autowired
    public void setBaseDao(EmployeeecDao dao) {
        this.baseDao = dao;
    }
}