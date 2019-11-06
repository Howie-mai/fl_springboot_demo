package com.zhku.mh.dao;

import com.zhku.mh.common.BaseDao;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import com.zhku.mh.entities.EmployeeExample;

import java.util.List;

public interface EmployeeDao extends BaseDao<Employee, EmployeeExample, Integer> {
    List<EmployeeDTO> getByDTO(EmployeeDTO employeeDTO);

    Employee getMaxWorkID();
}