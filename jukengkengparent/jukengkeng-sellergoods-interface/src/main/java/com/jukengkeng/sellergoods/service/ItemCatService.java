package com.jukengkeng.sellergoods.service;

import entity.pageResult;

/**
 * 商品分类管理
 * */
public interface ItemCatService {

    //获取分类列表
    pageResult queryList(Integer pageNum,Integer pageSize,Long parentID);
}
