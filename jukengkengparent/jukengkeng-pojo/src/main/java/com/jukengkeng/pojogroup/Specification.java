package com.jukengkeng.pojogroup;

import com.jukengkeng.pojo.TbSpecification;
import com.jukengkeng.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * 主从复合类，规格和规格名称复合类
 * */
public class Specification implements Serializable {
    private TbSpecification tbSpecification;
    private List<TbSpecificationOption> tbSpecificationOptions;

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getTbSpecificationOptions() {
        return tbSpecificationOptions;
    }

    public void setTbSpecificationOptions(List<TbSpecificationOption> tbSpecificationOptions) {
        this.tbSpecificationOptions = tbSpecificationOptions;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "tbSpecification=" + tbSpecification +
                ", tbSpecificationOptions=" + tbSpecificationOptions +
                '}';
    }
}
