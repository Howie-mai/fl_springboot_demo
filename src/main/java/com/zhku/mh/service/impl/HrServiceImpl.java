package com.zhku.mh.service.impl;

import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.HrDao;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.entities.HrExample;
import com.zhku.mh.entities.Role;
import com.zhku.mh.service.HrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class HrServiceImpl extends AbstractServiceImpl<Hr, HrExample, Integer> implements HrService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(HrServiceImpl.class);

    @Autowired
    public void setBaseDao(HrDao dao) {
        this.baseDao = dao;
    }
    @Autowired
    private HrDao hrDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        HrExample example = new HrExample();
        example.createCriteria().andUsernameEqualTo(s);
        List<Hr> hrList = baseDao.selectByExample(example);
        if(CollectionUtils.isEmpty(hrList)){
            throw new UsernameNotFoundException("当前用户不存在");
        }
        Hr hr = hrList.get(0);
        List<Role> roles = hrDao.getRolesByHrId(hr.getId());
        hr.setRoles(roles);
        return hr;
    }

    @Override
    public List<Hr> getAllHr(Integer hrId) {
       if(hrId == -1){
         /*
         * 查询所有hr信息
         */
         return baseDao.selectByExample(null);
       }
       HrExample example = new HrExample();
       example.createCriteria().andIdNotEqualTo(hrId);
       return baseDao.selectByExample(example);
    }
}
