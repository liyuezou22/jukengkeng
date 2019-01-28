package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbTypeTemplate;
import com.jukengkeng.sellergoods.service.TypeTemplateService;
import entity.pageResult;
import entity.result;
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
        return typeTemplateService.findPageList(tbTypeTemplate, pageNum, pageSize);
    }

    @RequestMapping("/saveTypeTemplate")
    public result saveTypeTemplate(@RequestBody TbTypeTemplate tbTypeTemplate) {
        try {
            typeTemplateService.saveTypeTemplate(tbTypeTemplate);
            return new result(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "保存失败");
        }
    }

    @RequestMapping("/delTypeTemplate")
    public result delTypeTemplate(Long[] ids) {
        try {
            typeTemplateService.deleteTypeTemplate(ids);
            return new result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "删除失败");
        }
    }

    @RequestMapping("/queryTypeTemplateByID")
    public TbTypeTemplate queryTypeTemplateByID(Long id) {
        return typeTemplateService.queryTypeTemplateByID(id);
    }

    @RequestMapping("/queryTypeTemplateByName")
    public pageResult queryTypeTemplateByName(Integer pageNum, Integer pageSize,@RequestBody TbTypeTemplate tbTypeTemplate) {
        System.out.println(tbTypeTemplate.getName());
        if(tbTypeTemplate.getName() != null){
            return typeTemplateService.findTypeTemplateByName(tbTypeTemplate.getName(), pageNum, pageSize);
        }
        return null;
    }

    @RequestMapping("/updateTypeTemplate")
    public result updateTypeTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            typeTemplateService.updateTypeTemplate(tbTypeTemplate);
            return new result(true,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return new result(false,"更新失败");
        }
    }
}
