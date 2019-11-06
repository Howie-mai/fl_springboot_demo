package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.MsgContentDao;
import com.zhku.mh.entities.MsgContent;
import com.zhku.mh.entities.MsgContentExample;
import com.zhku.mh.service.MsgContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgContentServiceImpl extends AbstractServiceImpl<MsgContent, MsgContentExample, Integer> implements MsgContentService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(MsgContentServiceImpl.class);

    @Autowired
    public void setBaseDao(MsgContentDao dao) {
        this.baseDao = dao;
    }
}