package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbBrand;
import entity.pageResult;

import java.util.List;

public interface BrandsService {
    //查询所有品牌
    public List<TbBrand> findAll();
     //查询分页数据
    public pageResult findPageList(int pageNum,int pageSize);
}
