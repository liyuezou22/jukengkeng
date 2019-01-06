package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojogroup.Specification;
import com.jukengkeng.sellergoods.service.SpecificationService;
import entity.pageResult;
import entity.result;
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

    //新增规格及选项
    @RequestMapping("/add")
    public result addSpecification(@RequestBody Specification specification) {
        try {
            specificationService.addSpecification(specification);
            return new result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "新增失败");
        }
    }

    //删除规格及选项
    @RequestMapping("/del")
    public result delSpecification(Long[] id) {
        try {
            specificationService.delSpecifciation(id);
            return new result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "删除失败");
        }
    }

}
