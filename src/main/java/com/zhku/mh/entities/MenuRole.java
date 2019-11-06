package com.zhku.mh.entities;

import java.io.Serializable;

/**
 * menu_role<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class MenuRole implements Serializable {
    private Integer id;

    private Integer mid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mid=").append(mid);
        sb.append(", rid=").append(rid);
        sb.append("]");
        return sb.toString();
    }
}