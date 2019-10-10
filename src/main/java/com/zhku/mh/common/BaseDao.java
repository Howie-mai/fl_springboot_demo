package com.zhku.mh.common;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-10 12:30
 */
public interface BaseDao<T extends Serializable, Example, ID extends Serializable> {

    long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(Example example);

    List<T> selectByExample(Example example);

    T selectByPrimaryKey(ID id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") Example example);

    int updateByExample(@Param("record") T record, @Param("example") Example example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
