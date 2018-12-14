package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbBrand;

import java.util.List;

public interface BrandsService {
    //查询所有品牌
    public List<TbBrand> findAll();
}
