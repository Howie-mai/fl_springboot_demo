package com.zhku.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.EmployeeDao;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import com.zhku.mh.entities.EmployeeExample;
import com.zhku.mh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, EmployeeExample, Integer> implements EmployeeService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    public void setBaseDao(EmployeeDao dao) {
        this.baseDao = dao;
    }

    @Autowired
    private EmployeeDao employeeDao;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    public List<Employee> getList() {
        return baseDao.selectByExample(null);
    }

    @Override
    public Integer getMaxWorkId() {
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
}