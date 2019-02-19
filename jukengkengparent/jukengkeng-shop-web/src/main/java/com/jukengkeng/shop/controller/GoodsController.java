package com.jukengkeng.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojogroup.Goods;
import com.jukengkeng.sellergoods.service.GoodsService;
import entity.result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private GoodsService goodsService;

    @RequestMapping("/addGoods")
    public result addGoods(@RequestBody Goods goods) {
        //获取登录名
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.getTbGoods().setSellerId(sellerId); //设置商家ID
        try {
            goodsService.addGoods(goods);
            return new result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "新增失败");
        }
    }
}
