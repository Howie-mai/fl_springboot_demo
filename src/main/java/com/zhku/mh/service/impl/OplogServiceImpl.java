package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.OplogDao;
import com.zhku.mh.entities.Oplog;
import com.zhku.mh.entities.OplogExample;
import com.zhku.mh.service.OplogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OplogServiceImpl extends AbstractServiceImpl<Oplog, OplogExample, Integer> implements OplogService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(OplogServiceImpl.class);

    @Autowired
    public void setBaseDao(OplogDao dao) {
        this.baseDao = dao;
    }
}