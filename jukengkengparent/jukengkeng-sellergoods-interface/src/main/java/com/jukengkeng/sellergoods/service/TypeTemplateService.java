package com.jukengkeng.sellergoods.service;

import com.jukengkeng.pojo.TbTypeTemplate;
import entity.pageResult;

import java.util.List;
import java.util.Map;

/**
 * 模板管理
 */
public interface TypeTemplateService {

    //分页查询
    pageResult findPageList(TbTypeTemplate tbTypeTemplate, Integer pageNum, Integer pageSize);
}
