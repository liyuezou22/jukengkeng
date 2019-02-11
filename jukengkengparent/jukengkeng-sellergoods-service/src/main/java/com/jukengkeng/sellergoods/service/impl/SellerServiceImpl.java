package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jukengkeng.mapper.TbSellerMapper;
import com.jukengkeng.pojo.TbSeller;
import com.jukengkeng.pojo.TbSellerExample;
import com.jukengkeng.sellergoods.service.SellerService;
import entity.pageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private TbSellerMapper tbSellerMapper;

    @Override
    public void addSeller(TbSeller tbSeller) {
        tbSellerMapper.insert(tbSeller);
    }

    @Override
    public pageResult queryListSeller(int pageNum, int pageSize, TbSeller tbSeller) {
        PageHelper.startPage(pageNum,pageSize);
        TbSellerExample tbSellerExample = new TbSellerExample();
        TbSellerExample.Criteria criteria = tbSellerExample.createCriteria();
        if(tbSeller != null){
            //公司名称
            if(tbSeller.getName() != null){
                criteria.andNameLike("%"+tbSeller.getName()+"%");
            }
            //店铺名称
            if(tbSeller.getNickName() != null){
                criteria.andNameLike("%"+tbSeller.getNickName()+"%");
            }
        }
       Page<TbSeller> tbSellers = (Page<TbSeller>) tbSellerMapper.selectByExample(tbSellerExample);
        return new pageResult(tbSellers.getTotal(),tbSellers.getResult());
    }
}
