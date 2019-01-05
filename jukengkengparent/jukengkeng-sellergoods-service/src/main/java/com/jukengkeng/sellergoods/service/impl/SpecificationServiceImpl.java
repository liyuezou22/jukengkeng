package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jukengkeng.mapper.TbSpecificationMapper;
import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojo.TbSpecificationExample;
import com.jukengkeng.sellergoods.service.SpecificationService;
import entity.pageResult;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    @Override
    public pageResult findPageList(Integer pageNum, Integer pageSize, TbSpecification tbSpecification) {
        PageHelper.startPage(pageNum, pageSize);
        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
        if (tbSpecification != null) {
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().length() > 0) {
                criteria.andSpecNameLike("%" + tbSpecification.getSpecName() + "%");
            }

        }
        Page<TbSpecification> tbSpecifications = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(tbSpecificationExample);

        return new pageResult(tbSpecifications.getTotal(), tbSpecifications.getResult());
    }
}
