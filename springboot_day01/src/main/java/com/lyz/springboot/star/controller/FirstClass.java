package com.lyz.springboot.star.controller;

import com.lyz.springboot.star.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstClass {
    @Value("${lyz.msg}")
    private String msg;

    @RequestMapping("/hello")
    public void sayHello(){
//        int i = 1/0;
//        return i;
        throw new BusinessException("100","用户命密码错误");
    }
}
