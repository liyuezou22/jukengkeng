package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jukengkeng.mapper.TbItemCatMapper;
import com.jukengkeng.pojo.TbItemCat;
import com.jukengkeng.pojo.TbItemCatExample;
import com.jukengkeng.sellergoods.service.ItemCatService;
import entity.pageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public pageResult queryList(Integer pageNum, Integer pageSize, Long parentID) {
        PageHelper.startPage(pageNum, pageSize);
        TbItemCatExample itemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = itemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentID);
        Page<TbItemCat> tbItemCats = (Page<TbItemCat>) itemCatMapper.selectByExample(itemCatExample);
        return new pageResult(tbItemCats.getTotal(), tbItemCats.getResult());
    }
}
