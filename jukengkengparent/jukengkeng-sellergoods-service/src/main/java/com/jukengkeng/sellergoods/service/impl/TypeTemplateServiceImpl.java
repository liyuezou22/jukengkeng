package com.jukengkeng.sellergoods.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jukengkeng.mapper.TbTypeTemplateMapper;
import com.jukengkeng.pojo.TbTypeTemplate;
import com.jukengkeng.pojo.TbTypeTemplateExample;
import com.jukengkeng.sellergoods.service.TypeTemplateService;
import entity.pageResult;
import entity.result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    @Override
    public pageResult findPageList(TbTypeTemplate tbTypeTemplate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();
        String name =  tbTypeTemplate.getName();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameEqualTo(name);
        }
        Page<TbTypeTemplate> tbTypeTemplates = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(example);

        return new pageResult(tbTypeTemplates.getTotal(),tbTypeTemplates.getResult());
    }

    @Override
    public void saveTypeTemplate(TbTypeTemplate tbTypeTemplate) {
        //将参数转换为json格式存储
        tbTypeTemplateMapper.insert(tbTypeTemplate);
    }
}
