package com.zhku.mh.service;

import com.github.pagehelper.PageInfo;
import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import com.zhku.mh.entities.EmployeeExample;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, EmployeeExample, Integer> {
    PageInfo<EmployeeDTO> getList(Integer pageNum, Integer pageSize, Employee employee, String beginDateScope);

    List<Employee> getList();

    Integer getMaxWorkId();

    Integer deleteList(List<Integer> ids);
}