package com.jukengkeng.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbBrand;
import com.jukengkeng.sellergoods.service.BrandsService;
import entity.pageResult;
import entity.result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Reference
    private BrandsService brandsService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        List<TbBrand> tbBrands = brandsService.findAll();
        return tbBrands;
    }

    @RequestMapping("/findPageList")
    public pageResult findPageList(int pageNum, int pageSize) {
        pageResult pageResult = brandsService.findPageList(pageNum, pageSize);
        return pageResult;
    }

    @RequestMapping("/add")
    public result add(@RequestBody TbBrand tbBrand) {
        try {
            brandsService.saveBrand(tbBrand);
            return new result(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "保存失败");
        }
    }

    @RequestMapping("/findTbBrand")
    public TbBrand findTbBrand(Long rowid) {
        TbBrand tbBrand = brandsService.findTbBrand(rowid);
        return tbBrand;
    }

    @RequestMapping("/updateTbBrand")
    public result updateTbBrand(@RequestBody TbBrand tbBrand) {
        try {
            brandsService.updateTbBrand(tbBrand);
            return new result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "修改失败");
        }
    }

    @RequestMapping("/del")
    public result deleteTbBrans(Long[] ids) {
        try {
            brandsService.deleteTbBrands(ids);
            return new result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new result(false, "删除失败");
        }

    }

    @RequestMapping("/findPageListByLike")
    public pageResult findPageListByLike(@RequestBody TbBrand tbBrand,Integer pageNum,Integer pageSize){
        System.out.println("pageNum --- >" + pageNum);
        System.out.println("pageSize --- >" + pageSize);
        return  brandsService.findPageListByLike(tbBrand,pageNum,pageSize);
    }

}
