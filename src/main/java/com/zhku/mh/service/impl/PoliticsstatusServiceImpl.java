package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.PoliticsstatusDao;
import com.zhku.mh.entities.Politicsstatus;
import com.zhku.mh.entities.PoliticsstatusExample;
import com.zhku.mh.service.PoliticsstatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliticsstatusServiceImpl extends AbstractServiceImpl<Politicsstatus, PoliticsstatusExample, Integer> implements PoliticsstatusService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(PoliticsstatusServiceImpl.class);

    @Autowired
    public void setBaseDao(PoliticsstatusDao dao) {
        this.baseDao = dao;
    }
}