package com.zhku.mh.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * employeetrain<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class EmployeeTrain implements Serializable {
    private Integer id;

    /**
     * 员工编号
     */
    private Integer eid;

    /**
     * 培训日期
     */
    private Date traindate;

    /**
     * 培训内容
     */
    private String traincontent;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getTraindate() {
        return traindate;
    }

    public void setTraindate(Date traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eid=").append(eid);
        sb.append(", traindate=").append(traindate);
        sb.append(", traincontent=").append(traincontent);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}