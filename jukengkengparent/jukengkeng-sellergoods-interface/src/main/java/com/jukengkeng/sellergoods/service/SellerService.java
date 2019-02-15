package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbSeller;
import entity.pageResult;
import entity.result;

import java.util.List;

public interface SellerService {
    //新增商家：商家入驻
    void addSeller(TbSeller tbSeller);
    //分页查询商家
    pageResult queryListSeller(int pageNum, int pageSize, TbSeller tbSeller);
    //根据ID查询商家信息
    TbSeller querySellerByID(String rowid);
    //修改商家审核状态
    void changeStatus(String rowid,String status);
}
