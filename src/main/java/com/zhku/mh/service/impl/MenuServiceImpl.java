package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.common.utils.MyKeyGenerator;
import com.zhku.mh.dao.MenuDao;
import com.zhku.mh.entities.DTO.MenuDTO;
import com.zhku.mh.entities.Menu;
import com.zhku.mh.entities.MenuExample;
import com.zhku.mh.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuServiceImpl extends AbstractServiceImpl<Menu, MenuExample, Integer> implements MenuService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    public void setBaseDao(MenuDao dao) {
        this.baseDao = dao;
    }

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MyKeyGenerator myKeyGenerator;

    @Cacheable(key = "#root.methodName")
    @Override
    public List<MenuDTO> getAllMenu() {
        return menuDao.getAllMenu();
    }

//    @Cacheable(keyGenerator = "myKeyGenerator")
    @Override
    public List<MenuDTO> getMenusByHrId(Integer hrId) {
        return menuDao.getMenusByHrId(hrId);
    }


}