package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.SysmsgDao;
import com.zhku.mh.entities.Sysmsg;
import com.zhku.mh.entities.SysmsgExample;
import com.zhku.mh.service.SysmsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysmsgServiceImpl extends AbstractServiceImpl<Sysmsg, SysmsgExample, Integer> implements SysmsgService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SysmsgServiceImpl.class);

    @Autowired
    public void setBaseDao(SysmsgDao dao) {
        this.baseDao = dao;
    }
}