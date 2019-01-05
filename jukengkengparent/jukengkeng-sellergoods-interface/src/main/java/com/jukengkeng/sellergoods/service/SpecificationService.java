package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbSpecification;
import entity.pageResult;

public interface SpecificationService {
    //规格分页方法
    pageResult findPageList(Integer pageNum, Integer pageSize, TbSpecification tbSpecification);
}
