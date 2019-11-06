package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmpSalaryDao;
import com.zhku.mh.entities.EmpSalary;
import com.zhku.mh.entities.EmpSalaryExample;
import com.zhku.mh.service.EmpSalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpSalaryServiceImpl extends AbstractServiceImpl<EmpSalary, EmpSalaryExample, Integer> implements EmpSalaryService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmpSalaryServiceImpl.class);

    @Autowired
    public void setBaseDao(EmpSalaryDao dao) {
        this.baseDao = dao;
    }
}