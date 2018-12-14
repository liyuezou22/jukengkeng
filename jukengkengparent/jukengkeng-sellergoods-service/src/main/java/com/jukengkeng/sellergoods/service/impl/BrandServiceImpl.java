package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jukengkeng.mapper.TbBrandMapper;
import com.jukengkeng.pojo.TbBrand;
import com.jukengkeng.sellergoods.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandsService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }
}
