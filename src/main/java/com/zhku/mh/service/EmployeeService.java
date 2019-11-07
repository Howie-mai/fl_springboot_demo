package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import com.zhku.mh.entities.EmployeeExample;

import java.util.List;
import java.util.Map;

public interface EmployeeService extends BaseService<Employee, EmployeeExample, Integer> {
    PageInfo<EmployeeDTO> getList(Integer pageNum, Integer pageSize, Employee employee, String beginDateScope);

    List<Employee> getList();

    Integer deleteList(List<Integer> ids);

    Map<String, Object> saveEmp(Employee employee);

    Map<String, Object> getBasicData();
}
