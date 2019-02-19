package com.jukengkeng.pojogroup;

import com.jukengkeng.pojo.TbGoods;
import com.jukengkeng.pojo.TbGoodsDesc;
import com.jukengkeng.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合实体类
 * */
public class Goods implements Serializable {
    private TbGoods tbGoods; //商品SPU类
    private TbGoodsDesc tbGoodsDesc; //商品SPU说明类
    private List<TbItem> tbItems; //商品SKU类

    public TbGoods getTbGoods() {
        return tbGoods;
    }

    public void setTbGoods(TbGoods tbGoods) {
        this.tbGoods = tbGoods;
    }

    public TbGoodsDesc getTbGoodsDesc() {
        return tbGoodsDesc;
    }

    public void setTbGoodsDesc(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDesc = tbGoodsDesc;
    }

    public List<TbItem> getTbItems() {
        return tbItems;
    }

    public void setTbItems(List<TbItem> tbItems) {
        this.tbItems = tbItems;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "tbGoods=" + tbGoods +
                ", tbGoodsDesc=" + tbGoodsDesc +
                ", tbItems=" + tbItems +
                '}';
    }
}
