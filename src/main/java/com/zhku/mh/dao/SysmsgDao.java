package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.DTO.SysmsgDTO;
import com.zhku.mh.entities.Sysmsg;
import com.zhku.mh.entities.SysmsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysmsgDao extends BaseDao<Sysmsg, SysmsgExample, Integer> {
    List<SysmsgDTO> getSysMsg(@Param("hrId") Integer id);
}
