package com.zhku.mh.controller;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.result.RespBean;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import com.zhku.mh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public  class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private NationService nationService;
    @Autowired
    private PoliticsstatusService politicsstatusService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private JobLevelService jobLevelService;

    @RequestMapping("/list")
    public RespBean getList(@RequestParam(required = false) Integer pageNum,
                            @RequestParam(required = false) Integer pageSize,
                            @RequestParam(required = false) String beginTimeScope,
                            @RequestBody Employee employee) {
        RespBean respBean;
        if(pageNum == null || pageSize == null){
            return RespBean.ok("查询成功",employeeService.getList());
        }
        PageInfo<EmployeeDTO> pageInfo = employeeService.getList(pageNum,pageSize,employee,beginTimeScope);
        if(CollectionUtils.isEmpty(pageInfo.getList())){
            respBean = RespBean.ok("数据为空");
            return respBean;
        }
        respBean = RespBean.ok("查询成功",pageInfo.getList());
        respBean.setTotal(pageInfo.getTotal());
        return respBean;
    }

    @RequestMapping("/basicData")
    public RespBean getBasicdata(){
        Map<String, Object> map = new HashMap<>();
        map.put("nations", nationService.selectByExample(null));
        map.put("politics", politicsstatusService.selectByExample(null));
        map.put("deps", departmentService.queryWithChildren());
        map.put("positions", positionService.selectByExample(null));
        map.put("joblevels", jobLevelService.selectByExample(null));
        return RespBean.ok("基础信息查询成功",map);
    }

    @RequestMapping("/save")
    public RespBean save(@RequestBody Employee employee){
        Integer workId = employeeService.getMaxWorkId();
        String workID = String.format("%08d",workId);
        employee.setWorkid(workID);
        Integer id = employeeService.insertSelectiveForId(employee);
        employee.setId(id);
        if(id != null){
            return RespBean.ok("添加成功",employee);
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping("/get/{id}")
    public RespBean get(@PathVariable Integer id){
        if(id != null){
            return RespBean.ok("查询成功",employeeService.selectByPrimaryKey(id));
        }
        return RespBean.error("查询失败");
    }

    @RequestMapping("/delete/{id}")
    public RespBean delete(@PathVariable Integer id){
        employeeService.deleteByPrimaryKey(id);
        if(id != null){
            return RespBean.ok("删除成功",employeeService.selectByPrimaryKey(id));
        }
        return RespBean.error("删除失败");
    }

    @RequestMapping("/deleteList")
    public RespBean deleteList(@RequestBody List<Integer> ids){
        int count = employeeService.deleteList(ids);
        if(ids.size() == count){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @RequestMapping("/update")
    public RespBean update(@RequestBody Employee employee){
        int count = employeeService.updateByPrimaryKey(employee);
        if(count == 1){
            return RespBean.ok("更改成功");
        }
        return RespBean.error("更改失败");
    }

//    @RequestMapping("/getDept")
//    public RespBean getDept(){
//        return RespBean.ok("基础信息查询成功",departmentService.queryWithChildren());
//    }
}