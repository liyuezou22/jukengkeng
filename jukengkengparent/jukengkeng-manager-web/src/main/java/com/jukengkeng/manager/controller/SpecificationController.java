package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.sellergoods.service.SpecificationService;
import entity.pageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;

    //分页查询
    @RequestMapping("/findPageList")
    public pageResult findPageList(Integer pageNum, Integer pageSize, @RequestBody TbSpecification tbSpecification) {
        return specificationService.findPageList(pageNum, pageSize, tbSpecification);
    }

}
