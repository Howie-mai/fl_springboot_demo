package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.AppraiseDao;
import com.zhku.mh.entities.Appraise;
import com.zhku.mh.entities.AppraiseExample;
import com.zhku.mh.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraiseServiceImpl extends AbstractServiceImpl<Appraise, AppraiseExample, Integer> implements AppraiseService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AppraiseServiceImpl.class);

    @Autowired
    public void setBaseDao(AppraiseDao dao) {
        this.baseDao = dao;
    }
}