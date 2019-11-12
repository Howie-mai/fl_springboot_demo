package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.SysmsgDTO;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.entities.Sysmsg;
import com.zhku.mh.entities.SysmsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysmsgService extends BaseService<Sysmsg, SysmsgExample, Integer> {
    PageInfo<SysmsgDTO> getSysMsgListByHrid(Integer pageNum, Integer pageSize);

    List<SysmsgDTO> getSysMsgListByHrid();

    Integer insertMsgMutipart(List<Hr> hrs, Integer mid);

    Boolean updateMsgStatus(Integer mid);
}
