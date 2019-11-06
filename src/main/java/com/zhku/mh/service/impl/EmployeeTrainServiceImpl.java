package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmployeeTrainDao;
import com.zhku.mh.entities.EmployeeTrain;
import com.zhku.mh.entities.EmployeeTrainExample;
import com.zhku.mh.service.EmployeeTrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTrainServiceImpl extends AbstractServiceImpl<EmployeeTrain, EmployeeTrainExample, Integer> implements EmployeeTrainService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployeeTrainServiceImpl.class);

    @Autowired
    public void setBaseDao(EmployeeTrainDao dao) {
        this.baseDao = dao;
    }
}