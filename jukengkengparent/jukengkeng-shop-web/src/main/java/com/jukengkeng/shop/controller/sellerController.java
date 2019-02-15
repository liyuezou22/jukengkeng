package com.jukengkeng.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbSeller;
import com.jukengkeng.sellergoods.service.SellerService;
import entity.result;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/seller")
public class sellerController {
    @Reference
    private SellerService sellerService;

    //新增商家
    @RequestMapping("/add")
    public result addSeller(@RequestBody TbSeller tbSeller) {
        tbSeller.setStatus("0");
        tbSeller.setCreateTime(new Date());
        //采用BCrypt加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String rewpassword = bCryptPasswordEncoder.encode(tbSeller.getPassword());
        tbSeller.setPassword(rewpassword);
        try {
            sellerService.addSeller(tbSeller);
            return new result(true, "保存成功，即将跳转到登陆页面");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "保存失败");
        }

    }
}
