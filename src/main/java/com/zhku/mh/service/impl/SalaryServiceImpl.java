package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.SalaryDao;
import com.zhku.mh.entities.Salary;
import com.zhku.mh.entities.SalaryExample;
import com.zhku.mh.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl extends AbstractServiceImpl<Salary, SalaryExample, Integer> implements SalaryService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);

    @Autowired
    public void setBaseDao(SalaryDao dao) {
        this.baseDao = dao;
    }
}