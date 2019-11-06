package com.zhku.mh.entities.DTO;

import java.io.Serializable;
import java.util.List;

public class DepartmentDTO implements Serializable {

    private static final long serialVersionUID = -984247929499729062L;

    private Integer value;

    private String label;

    private List<DepartmentDTO> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DepartmentDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentDTO> children) {
        this.children = children;
    }
}
