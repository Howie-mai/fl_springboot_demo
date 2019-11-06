package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.NationDao;
import com.zhku.mh.entities.Nation;
import com.zhku.mh.entities.NationExample;
import com.zhku.mh.service.NationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationServiceImpl extends AbstractServiceImpl<Nation, NationExample, Integer> implements NationService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(NationServiceImpl.class);

    @Autowired
    public void setBaseDao(NationDao dao) {
        this.baseDao = dao;
    }
}