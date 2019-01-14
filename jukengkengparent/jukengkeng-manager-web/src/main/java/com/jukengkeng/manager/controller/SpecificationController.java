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

import java.util.List;
import java.util.Map;

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

    //根据ID查询规格及规格选项
    @RequestMapping("/findSpecificationByID")
    public Specification findSpecificationByID(Long id) {
        return specificationService.findSpecificationByID(id);
    }

    //更新规格及规格选项
    @RequestMapping("/updateSpecification")
    public result updateSoecification(@RequestBody Specification specification) {
        try {
            specificationService.updateSpecification(specification);
            return new result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "修改失败");
        }
    }

    @RequestMapping("/selectSpecificationOption")
    public List<Map> selectSpecificationOption() {
        return specificationService.selectSpecificationOption();
    }
}
