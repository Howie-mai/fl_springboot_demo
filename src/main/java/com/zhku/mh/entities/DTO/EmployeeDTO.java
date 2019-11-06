package com.zhku.mh.entities.DTO;

import com.zhku.mh.entities.Employee;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDTO extends Employee implements Serializable {
    private String nationName;
    private String politicsStatusName;
    private String positionName;
    private String jobLevelName;
    private String departmentName;
    private Date startBeginDate;
    private Date endBeginDate;

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getPoliticsStatusName() {
        return politicsStatusName;
    }

    public void setPoliticsStatusName(String politicsStatusName) {
        this.politicsStatusName = politicsStatusName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getJobLevelName() {
        return jobLevelName;
    }

    public void setJobLevelName(String jobLevelName) {
        this.jobLevelName = jobLevelName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getStartBeginDate() {
        return startBeginDate;
    }

    public void setStartBeginDate(Date startBeginDate) {
        this.startBeginDate = startBeginDate;
    }

    public Date getEndBeginDate() {
        return endBeginDate;
    }

    public void setEndBeginDate(Date endBeginDate) {
        this.endBeginDate = endBeginDate;
    }
}
