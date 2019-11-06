package com.zhku.mh.entities;

import java.io.Serializable;

/**
 * empsalary<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class EmpSalary implements Serializable {
    private Integer id;

    private Integer eid;

    private Integer sid;

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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eid=").append(eid);
        sb.append(", sid=").append(sid);
        sb.append("]");
        return sb.toString();
    }
}