package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.sellergoods.service.ItemCatService;
import entity.pageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品分类管理
 */
@RestController
@RequestMapping("/ItemCat")
public class ItemCatController {
    @Reference
    private ItemCatService itemCatService;

    @RequestMapping("/queryList")
    public pageResult queryList(Integer pageNum, Integer pageSize, Long parentID) {
        pageResult pageResult = itemCatService.queryList(pageNum, pageSize, parentID);
        return pageResult;
    }


}
