package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbTypeTemplate;
import com.jukengkeng.sellergoods.service.TypeTemplateService;
import entity.pageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 模板管理
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/findPageList")
    public pageResult findPageList(@RequestBody TbTypeTemplate tbTypeTemplate, Integer pageNum, Integer pageSize) {
        return typeTemplateService.findPageList(tbTypeTemplate,pageNum,pageSize);
    }

}
