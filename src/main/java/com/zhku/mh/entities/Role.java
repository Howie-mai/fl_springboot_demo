package com.zhku.mh.entities;

import java.io.Serializable;

/**
 * role<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class Role implements Serializable {
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    private String namezh;

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

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", namezh=").append(namezh);
        sb.append("]");
        return sb.toString();
    }
}