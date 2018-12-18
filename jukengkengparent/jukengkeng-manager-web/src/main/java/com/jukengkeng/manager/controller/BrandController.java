package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbBrand;
import com.jukengkeng.sellergoods.service.BrandsService;
import entity.pageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("brands")
public class BrandController {
    @Reference
    private BrandsService brandsService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        List<TbBrand> tbBrands = brandsService.findAll();
        return tbBrands;
    }
    @RequestMapping("/findPageList")
    public pageResult findPageList(int pageNum,int pageSize){
       pageResult pageResult =  brandsService.findPageList(pageNum,pageSize);
       return  pageResult;
    }
}
