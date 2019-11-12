package com.zhku.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.common.utils.HrUtil;
import com.zhku.mh.dao.SysmsgDao;
import com.zhku.mh.entities.DTO.SysmsgDTO;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.entities.Sysmsg;
import com.zhku.mh.entities.SysmsgExample;
import com.zhku.mh.service.HrService;
import com.zhku.mh.service.SysmsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysmsgServiceImpl extends AbstractServiceImpl<Sysmsg, SysmsgExample, Integer> implements SysmsgService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SysmsgServiceImpl.class);

    @Autowired
    public void setBaseDao(SysmsgDao dao) {
        this.baseDao = dao;
    }

    @Autowired
    private SysmsgDao sysmsgDao;

    @Override
    public PageInfo<SysmsgDTO> getSysMsgListByHrid(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysmsgDTO> dataList = sysmsgDao.getSysMsg(HrUtil.getCurrentHr().getId());
        return new PageInfo<>(dataList);
    }

    @Override
    public List<SysmsgDTO> getSysMsgListByHrid() {
        return sysmsgDao.getSysMsg(HrUtil.getCurrentHr().getId());
    }

    @Override
    public Integer insertMsgMutipart(List<Hr> hrs, Integer mid) {
        return sysmsgDao.insertMsgMutipart(hrs,mid);
    }

    @Override
    public Boolean updateMsgStatus(Integer mid) {
        if (mid != -1) {
            return sysmsgDao.updateMsgStatus(mid,HrUtil.getCurrentHr().getId()) == 1;
        }
        sysmsgDao.updateMsgStatus(mid,HrUtil.getCurrentHr().getId());
        return true;
    }
}
