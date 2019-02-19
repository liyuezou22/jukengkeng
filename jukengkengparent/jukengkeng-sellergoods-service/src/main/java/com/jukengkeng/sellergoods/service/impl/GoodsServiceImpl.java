package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jukengkeng.mapper.TbGoodsDescMapper;
import com.jukengkeng.mapper.TbGoodsMapper;
import com.jukengkeng.pojogroup.Goods;
import com.jukengkeng.sellergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;
    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    @Override
    public void addGoods(Goods goods) {
        goods.getTbGoods().setAuditStatus("0"); //设置状态为未申请状态
        tbGoodsMapper.insert(goods.getTbGoods());
        goods.getTbGoodsDesc().setGoodsId(goods.getTbGoods().getId()); //设置SPU主键到SPU拓展表中
        tbGoodsDescMapper.insert(goods.getTbGoodsDesc()); //插入SPU拓展属性表
    }
}
