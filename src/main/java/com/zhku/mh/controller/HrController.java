package com.zhku.mh.controller;

import com.zhku.mh.common.result.RespBean;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName：
 * Time：2019/11/11 14:00
 * Description：
 * Author： mh
 */
@RestController
@RequestMapping("/hr")
public class HrController {
    @Autowired
    private HrService hrService;

    @RequestMapping("/listHr")
    public RespBean listHr(@RequestParam(required = false) Integer hrId){
        RespBean result;
        List<Hr> dataList = hrService.getAllHr(hrId);
        if(CollectionUtils.isEmpty(dataList)){
            return RespBean.ok("Hr列表为空");
        }
        result = RespBean.ok("查询成功", dataList);
        Integer total = dataList.size();
        result.setTotal(total.longValue());
        return result;
    }
}
