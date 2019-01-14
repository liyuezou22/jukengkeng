package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jukengkeng.mapper.TbSpecificationMapper;
import com.jukengkeng.mapper.TbSpecificationOptionMapper;
import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojo.TbSpecificationExample;
import com.jukengkeng.pojo.TbSpecificationOption;
import com.jukengkeng.pojo.TbSpecificationOptionExample;
import com.jukengkeng.pojogroup.Specification;
import com.jukengkeng.sellergoods.service.SpecificationService;
import entity.pageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

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

    @Override
    public void addSpecification(Specification specification) {
        tbSpecificationMapper.insert(specification.getTbSpecification());//插入规格
        //插入规格选项
        List<TbSpecificationOption> tbSpecificationOptions = specification.getTbSpecificationOptions();
        for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
            tbSpecificationOption.setSpecId(specification.getTbSpecification().getId());
            tbSpecificationOptionMapper.insert(tbSpecificationOption);
        }
    }

    @Override
    public void delSpecifciation(Long[] ids) {
        for (Long id : ids) {
            tbSpecificationMapper.deleteByPrimaryKey(id);//删除规格
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(example);//删除规格选项
        }
    }

    @Override
    public Specification findSpecificationByID(Long id) {
        Specification specification = new Specification();
        //查询规格
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        specification.setTbSpecification(tbSpecification);
        //查询规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectByExample(example);
        specification.setTbSpecificationOptions(tbSpecificationOptions);

        return specification;
    }

    @Override
    public void updateSpecification(Specification specification) {
        //更新规格主表
        TbSpecification tbSpecification = specification.getTbSpecification();
        if (tbSpecification != null) {
            tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
        }
        //跟新规格选项表
        List<TbSpecificationOption> tbSpecificationOptions = specification.getTbSpecificationOptions();
        for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
            tbSpecificationOptionMapper.updateByPrimaryKey(tbSpecificationOption);
        }
    }

    @Override
    public List<Map> selectSpecificationOption() {
        return tbSpecificationMapper.selectSpecificationOption();
    }
}
