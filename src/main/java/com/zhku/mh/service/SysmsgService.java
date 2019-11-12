package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.SysmsgDTO;
import com.zhku.mh.entities.Sysmsg;
import com.zhku.mh.entities.SysmsgExample;

import java.util.List;

public interface SysmsgService extends BaseService<Sysmsg, SysmsgExample, Integer> {
    PageInfo<SysmsgDTO> getSysMsgListByHrid(Integer pageNum, Integer pageSize);

    List<SysmsgDTO> getSysMsgListByHrid();
}
