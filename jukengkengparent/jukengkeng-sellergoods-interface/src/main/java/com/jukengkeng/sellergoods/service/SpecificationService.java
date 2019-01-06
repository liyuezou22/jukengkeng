package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojogroup.Specification;
import entity.pageResult;

public interface SpecificationService {
    //规格分页方法
    pageResult findPageList(Integer pageNum, Integer pageSize, TbSpecification tbSpecification);
    //新增规格及规格选项
    void addSpecification(Specification specification);
}
