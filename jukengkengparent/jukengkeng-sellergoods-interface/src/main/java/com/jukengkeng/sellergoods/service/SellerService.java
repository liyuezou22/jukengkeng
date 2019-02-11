package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbSeller;
import entity.pageResult;

import java.util.List;

public interface SellerService {
    //新增商家：商家入驻
    public void addSeller(TbSeller tbSeller);
    //分页查询商家
    public pageResult queryListSeller(int pageNum, int pageSize, TbSeller tbSeller);
}
