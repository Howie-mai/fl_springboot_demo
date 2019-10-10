package com.zhku.mh.common;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-10 12:28
 */
public interface BaseService<T extends Serializable, Example, ID extends Serializable> {

    long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    /**
     * 插入一条数据，获取id
     * 用于解决微服务controller层拿不到id的问题
     * @param record
     * @return 主键
     */
    ID insertForId(T record);
    /**
     * 插入一条数据，获取id
     * 用于解决微服务controller层拿不到id的问题
     * @param record
     * @return 主键
     */
    ID insertSelectiveForId(T record);

    List<T> selectByExampleWithBLOBs(Example example);

    List<T> selectByExample(Example example);

    T selectByPrimaryKey(ID id);

    int updateByExampleSelective(T record, Example example);

    int updateByExampleWithBLOBs(T record,Example example);

    int updateByExample(T record, Example example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
