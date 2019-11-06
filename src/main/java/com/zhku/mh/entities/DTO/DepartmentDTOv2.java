package com.zhku.mh.entities.DTO;

import com.zhku.mh.entities.Department;

import java.io.Serializable;
import java.util.List;

public class DepartmentDTOv2 implements Serializable {

    private static final long serialVersionUID = 1196581646116345853L;

    private Department department;

    private List<DepartmentDTOv2> children;

    private Integer level;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<DepartmentDTOv2> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentDTOv2> children) {
        this.children = children;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}