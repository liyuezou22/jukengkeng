package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojogroup.Specification;
import entity.pageResult;

public interface SpecificationService {
    //规格分页方法
    pageResult findPageList(Integer pageNum, Integer pageSize, TbSpecification tbSpecification);

    //新增规格及规格选项
    void addSpecification(Specification specification);

    //删除规格及规格选项
    void delSpecifciation(Long[] id);

    //根据ID查询规格及规格选项
    Specification findSpecificationByID(Long id);

    //更新规格及规格选项
    void updateSpecification(Specification specification);
}
