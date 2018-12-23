package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbBrand;
import entity.pageResult;
import java.util.List;

public interface BrandsService {
    //查询所有品牌
    public List<TbBrand> findAll();
     //查询分页数据
    public pageResult findPageList(int pageNum,int pageSize);
    //保存商品信息
    public void saveBrand(TbBrand tbBrand);
    //查询商品
    public TbBrand findTbBrand(Long id);
    //修改商品
    public void updateTbBrand(TbBrand tbBrand);
    //删除商品
    public void deleteTbBrands(Long[] ids);
    //模糊查询
    public pageResult findPageListByLike(TbBrand tbBrand,int pageNum,int pageSize);
}
