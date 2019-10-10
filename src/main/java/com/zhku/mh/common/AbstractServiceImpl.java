package com.zhku.mh.common;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-10 12:26
 */
@Service
public abstract class AbstractServiceImpl<T extends Serializable, Example, ID extends Serializable> implements BaseService<T, Example, ID> {

    protected BaseDao<T,Example,ID> baseDao;

    @Override
    public long countByExample(Example example) {
        return baseDao.countByExample(example);
    }

    @Override
    public int deleteByExample(Example example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(ID id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return baseDao.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseDao.insertSelective(record);
    }
    /**
     * 插入一条数据，获取id
     * 用于解决微服务controller层拿不到id的问题
     * @param record
     * @return 主键
     */
    @Override
    public ID insertForId(T record) {
        if(baseDao.insert(record) > 0) {
            try {
                Method getId = record.getClass().getMethod("getId");
                return (ID)getId.invoke(record);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    /**
     * 插入一条数据，获取id
     * 用于解决微服务controller层拿不到id的问题
     * @param record
     * @return 主键
     */
    @Override
    public ID insertSelectiveForId(T record) {
        if(baseDao.insertSelective(record) > 0) {
            try {
                Method getId = record.getClass().getMethod("getId");
                return (ID)getId.invoke(record);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public List<T> selectByExampleWithBLOBs(Example example) {
        return baseDao.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<T> selectByExample(Example example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(T record, Example example) {
        return baseDao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(T record, Example example) {
        return baseDao.updateByExampleWithBLOBs(record,example);
    }

    @Override
    public int updateByExample(T record, Example example) {
        return baseDao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return baseDao.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseDao.updateByPrimaryKey(record);
    }
}
