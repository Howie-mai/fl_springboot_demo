package com.zhku.mh.controller;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.result.RespBean;
import com.zhku.mh.entities.DTO.SysmsgDTO;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.service.HrService;
import com.zhku.mh.service.SysmsgService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName：
 * Time：2019/11/11 9:53
 * Description：
 * Author： mh
 */
@RestController
@RequestMapping("/sysMsg")
public class SysMsgController {
    @Autowired
    private SysmsgService sysmsgService;
    @Autowired
    private HrService hrService;

    @RequestMapping("/list")
    public RespBean List(@RequestParam(name = "pageNum", required = false) Integer pageNum,
                         @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        RespBean result;
        if(pageNum == null || pageSize == null){
            return RespBean.ok("查询所有信息成功",sysmsgService.getSysMsgListByHrid());
        }
        PageInfo<SysmsgDTO> pageInfo = sysmsgService.getSysMsgListByHrid(pageNum, pageSize);
        if (CollectionUtils.isEmpty(pageInfo.getList())) {
            return RespBean.ok("数据为空");
        }
        result = RespBean.ok("查询成功", pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
