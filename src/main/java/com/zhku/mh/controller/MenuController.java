package com.zhku.mh.controller;

import com.zhku.mh.common.result.RespBean;
import com.zhku.mh.common.utils.HrUtil;
import com.zhku.mh.entities.DTO.MenuDTO;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/hrMenu")
    public RespBean getHrMenu(){
        Hr hr = HrUtil.getCurrentHr();
        List<MenuDTO> dataList = menuService.getMenusByHrId(hr.getId());
        if(CollectionUtils.isEmpty(dataList)){
            return RespBean.error("没有可操作的菜单");
        }
        return RespBean.ok("查询成功",dataList);
    }

}
