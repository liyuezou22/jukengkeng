package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbTypeTemplate;
import entity.pageResult;
import entity.result;

import java.util.List;
import java.util.Map;

/**
 * 模板管理
 */
public interface TypeTemplateService {

    //分页查询
    pageResult findPageList(TbTypeTemplate tbTypeTemplate, Integer pageNum, Integer pageSize);

    //保存
    void saveTypeTemplate(TbTypeTemplate tbTypeTemplate);

    //删除
    void deleteTypeTemplate(Long[] ids);

    //更具ID查询
    TbTypeTemplate queryTypeTemplateByID(Long id);

    //根据规格模板名称查询
    pageResult findTypeTemplateByName(String name, Integer pageNum, Integer pageSize);

    //修改规格模板
    void updateTypeTemplate(TbTypeTemplate tbTypeTemplate);
}
