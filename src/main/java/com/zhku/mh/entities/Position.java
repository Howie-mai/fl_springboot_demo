package com.zhku.mh.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * position<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    private Date createdate;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createdate=").append(createdate);
        sb.append(", enabled=").append(enabled);
        sb.append("]");
        return sb.toString();
    }
}