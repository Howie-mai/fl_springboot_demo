package com.zhku.mh.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.zhku.mh.common.AbstractServiceImpl;
import com.zhku.mh.dao.DepartmentDao;
import com.zhku.mh.entities.DTO.DepartmentDTO;
import com.zhku.mh.entities.DTO.DepartmentDTOv2;
import com.zhku.mh.entities.Department;
import com.zhku.mh.entities.DepartmentExample;
import com.zhku.mh.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class DepartmentServiceImpl extends AbstractServiceImpl<Department, DepartmentExample, Integer> implements DepartmentService {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    public void setBaseDao(DepartmentDao dao) {
        this.baseDao = dao;
    }

    /**
     * 分级查询部门的列表
     *
     * @return: java.util.List<com.lkk.tyj.entities.dto.MallProductCategoryDTO>
     * @Date: 2019/9/29 12:47
     */
    @Override
    public List<DepartmentDTO> queryWithChildren() {
        List<Department> departmentList = baseDao.selectByExample(null);
        /*
         * 使用Multimap对以获取的分类按照父类Id进行组装
         */
        Multimap<Integer, Department> multimap = ArrayListMultimap.create();

        /*
         * 存入对象和它的父级分类ID
         */
        for (Department data : departmentList) {
            multimap.put(data.getParentid(), data);
        }

        return subType(-1, multimap, 0);
    }

    /**
     * 递归处理多级分类问题
     *
     * @param parentId 父级分类ID
     * @param maps     所有分类的按照父类ID组装后容器
     * @param level    分类的级别 0：根
     * @return: java.util.List<com.lkk.tyj.entities.dto.MallProductCategoryDTO>
     * @Date: 2019/9/29 13:00
     */
    private List<DepartmentDTO> subType(Integer parentId, Multimap<Integer, Department> maps, int level) {
        List<DepartmentDTO> list = new ArrayList<>();
        Collection<Department> trList = maps.get(parentId);
        Iterator<Department> iterator = trList.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setValue(department.getId());
            departmentDTO.setLabel(department.getName());
            list.add(departmentDTO);
            departmentDTO.setChildren(subType(department.getId(), maps, level + 1));
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * 分级查询商品分类的列表
     *
     * @return: java.util.List<com.lkk.tyj.entities.dto.MallProductCategoryDTO>
     * @Date: 2019/9/29 12:47
     */
    @Override
    public List<DepartmentDTOv2> queryWithChildrenV2() {
        List<Department> departmentList = baseDao.selectByExample(null);
        /*
         * 使用Multimap对以获取的分类按照父类Id进行组装
         */
        Multimap<Integer, Department> multimap = ArrayListMultimap.create();

        /*
         * 存入对象和它的父级分类ID
         */
        for (Department data : departmentList) {
            multimap.put(data.getParentid(), data);
        }

        return subTypeV2(-1, multimap, 0);
    }

    /**
     * 递归处理多级分类问题
     *
     * @param parentId 父级分类ID
     * @param maps     所有分类的按照父类ID组装后容器
     * @param level    分类的级别 0：根
     * @return: java.util.List<com.lkk.tyj.entities.dto.MallProductCategoryDTO>
     * @Date: 2019/9/29 13:00
     */
    private List<DepartmentDTOv2> subTypeV2(Integer parentId, Multimap<Integer, Department> maps, int level) {
        List<DepartmentDTOv2> list = new ArrayList<>();
        Collection<Department> trList = maps.get(parentId);
        Iterator<Department> iterator = trList.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            DepartmentDTOv2 departmentDTOv2 = new DepartmentDTOv2();
            departmentDTOv2.setDepartment(department);
            departmentDTOv2.setLevel(level);
            list.add(departmentDTOv2);
            departmentDTOv2.setChildren(subTypeV2(department.getId(), maps, level + 1));
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}