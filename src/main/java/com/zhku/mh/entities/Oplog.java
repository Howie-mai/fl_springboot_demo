package com.zhku.mh.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * oplog<p/>
 * @date Sat Oct 26 23:07:22 CST 2019
 *
 */
@SuppressWarnings("serial")
public class Oplog implements Serializable {
    private Integer id;

    /**
     * 添加日期
     */
    private Date adddate;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    private Integer hrid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adddate=").append(adddate);
        sb.append(", operate=").append(operate);
        sb.append(", hrid=").append(hrid);
        sb.append("]");
        return sb.toString();
    }
}