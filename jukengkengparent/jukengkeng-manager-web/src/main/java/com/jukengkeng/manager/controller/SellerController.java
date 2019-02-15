package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbSeller;
import com.jukengkeng.sellergoods.service.SellerService;
import entity.pageResult;
import entity.result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Reference
    private SellerService sellerService;

    @RequestMapping("/queryListSeller")
    public pageResult queryListSeller(int pageNum, int pageSize, @RequestBody TbSeller tbSeller) {
        return sellerService.queryListSeller(pageNum, pageSize, tbSeller);
    }

    @RequestMapping("/querySellerByID")
    public TbSeller querySellerByID(String rowid) {
        return sellerService.querySellerByID(rowid);
    }

    @RequestMapping("/changStatus")
    public result changeStatus(String rowid,String status){
        try {
            sellerService.changeStatus(rowid,status);
            return new result(true,"操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return new result(false,"操作失败");
        }

    }
}
