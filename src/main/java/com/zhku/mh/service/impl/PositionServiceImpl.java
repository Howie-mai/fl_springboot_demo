package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.PositionDao;
import com.zhku.mh.entities.Position;
import com.zhku.mh.entities.PositionExample;
import com.zhku.mh.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends AbstractServiceImpl<Position, PositionExample, Integer> implements PositionService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    public void setBaseDao(PositionDao dao) {
        this.baseDao = dao;
    }
}