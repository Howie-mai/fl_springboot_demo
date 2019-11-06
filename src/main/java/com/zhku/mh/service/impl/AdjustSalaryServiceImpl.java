package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.AdjustSalaryDao;
import com.zhku.mh.entities.AdjustSalary;
import com.zhku.mh.entities.AdjustSalaryExample;
import com.zhku.mh.service.AdjustSalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdjustSalaryServiceImpl extends AbstractServiceImpl<AdjustSalary, AdjustSalaryExample, Integer> implements AdjustSalaryService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AdjustSalaryServiceImpl.class);

    @Autowired
    public void setBaseDao(AdjustSalaryDao dao) {
        this.baseDao = dao;
    }
}