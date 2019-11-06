package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.JobLevelDao;
import com.zhku.mh.entities.JobLevel;
import com.zhku.mh.entities.JobLevelExample;
import com.zhku.mh.service.JobLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobLevelServiceImpl extends AbstractServiceImpl<JobLevel, JobLevelExample, Integer> implements JobLevelService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(JobLevelServiceImpl.class);

    @Autowired
    public void setBaseDao(JobLevelDao dao) {
        this.baseDao = dao;
    }
}