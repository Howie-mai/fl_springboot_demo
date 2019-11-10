package com.zhku.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmployeeDao;
import com.zhku.mh.entities.*;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, EmployeeExample, Integer> implements EmployeeService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    public void setBaseDao(EmployeeDao dao) {
        this.baseDao = dao;
    }

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

    @Autowired
    private EmployeeDao employeeDao;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public PageInfo<EmployeeDTO> getList(Integer pageNum, Integer pageSize, Employee employee, String beginDateScope) {
        PageHelper.startPage(pageNum, pageSize);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);

        if (beginDateScope != null && beginDateScope.contains(",")) {
            Date startBeginDate = null;
            Date endBeginDate = null;
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            employeeDTO.setStartBeginDate(startBeginDate);
            employeeDTO.setEndBeginDate(endBeginDate);
        }

        List<EmployeeDTO> dataList = employeeDao.getByDTO(employeeDTO);
        PageInfo<EmployeeDTO> pageInfo = new PageInfo<>(dataList);
        return pageInfo;
    }

    @Override
    public List<EmployeeDTO> getAllEmpDto() {
        EmployeeDTO dto = new EmployeeDTO();
        return employeeDao.getByDTO(dto);
    }

    @Override
    public List<Employee> getList() {
        return baseDao.selectByExample(null);
    }

    private Integer getMaxWorkId() {
        Employee employee = employeeDao.getMaxWorkID();
        if (employee.getWorkid() == null) {
            return 0;
        }
        return Integer.parseInt(employee.getWorkid())+1;
    }

    @Override
    public Integer deleteList(List<Integer> ids) {
       EmployeeExample example = new EmployeeExample();
       example.createCriteria().andIdIn(ids);
       return baseDao.deleteByExample(example);
    }

    @Override
    public Map<String, Object> saveEmp(Employee employee){

        Integer workId = getMaxWorkId();
        String workID = String.format("%08d",workId);
        employee.setWorkid(workID);

        /*
        * 合同年限
        */
        Date beginContract = employee.getBegincontract();
        Date endContract = employee.getEndcontract();
        Double contractTerm = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(contractTerm / 12)));

        int count = baseDao.insertSelective(employee);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);

        List<Position> positions = positionService.selectByExample(null);
        for (Position position:positions) {
            if(employeeDTO.getPosid() == position.getId()){
                employeeDTO.setPositionName(position.getName());
            }
        }

        List<Department> departments = departmentService.selectByExample(null);
        for (Department department:departments) {
            if(employeeDTO.getDepartmentid() == department.getId()){
                employeeDTO.setDepartmentName(department.getName());
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("result",count);
        map.put("dto",employeeDTO);
        return map;
    }

    @Override
    public int addEmps(List<EmployeeDTO> dataList){
        return employeeDao.addEmps(dataList);
    }

    @Override
    public Map<String, Object> getBasicData(boolean isWithChildren) {
        Map<String, Object> map = new HashMap<>();
        map.put("nations", nationService.selectByExample(null));
        map.put("politics", politicsstatusService.selectByExample(null));
        if(isWithChildren){
            map.put("deps", departmentService.queryWithChildren());
        }else {
            map.put("deps", departmentService.selectByExample(null));
        }
        map.put("positions", positionService.selectByExample(null));
        map.put("joblevels", jobLevelService.selectByExample(null));
        return map;
    }

}
