package com.huwei.week11.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 商品
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2021/1/6 11:24
 * @FileName: Good
 * Copyright (C), 2015-2021
 */
@Table(name = "tb_good")
public class Good implements Serializable {
    /**
     * 商品标识
     */
    @Id
    @Column(name = "good_id")
    private Integer goodId;

    /**
     * 商品名称
     */
    @Column(name = "good_name")
    private String goodName;

    /**
     * 商品库存
     */
    @Column(name = "good_stock")
    private Integer goodStock;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(Integer goodStock) {
        this.goodStock = goodStock;
    }
}
