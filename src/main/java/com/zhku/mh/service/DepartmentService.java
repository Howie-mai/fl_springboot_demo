package com.zhku.mh.service;

import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.DTO.DepartmentDTO;
import com.zhku.mh.entities.DTO.DepartmentDTOv2;
import com.zhku.mh.entities.Department;
import com.zhku.mh.entities.DepartmentExample;

import java.util.List;

public interface DepartmentService extends BaseService<Department, DepartmentExample, Integer> {
    List<DepartmentDTO> queryWithChildren();

    List<DepartmentDTOv2> queryWithChildrenV2();
}