package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created on 15/7/27.
 * @author nico
 */
public class Product {
    //服务id
    @JSONField(name = "id")
    private int id;

    //服务名称
    @JSONField(name = "name")
    private String name;

    //参考价
    @JSONField(name = "indicative_price")
    private double indicative_price;

    //服务简介
    @JSONField(name = "summary")
    private String summary;

    //image url
    @JSONField(name = "image")
    private String image;

    //服务分类
    @JSONField(name = "category")
    private Category category;

    public Product(int id, String name, double indicative_price, String summary, String image, Category category)
    {
        this.id = id;
        this.name = name;
        this.indicative_price = indicative_price;
        this.summary = summary;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getIndicative_price() {
        return indicative_price;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public Category getCategory() {
        return category;
    }
}
