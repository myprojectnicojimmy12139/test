package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created on 15/7/27.
 * @author nico
 */
public class Category implements Serializable {


    @JSONField(name = "id")
    private int id;

    @JSONField(name = "name")
    private String name;

    public Category(int id,String name)
    {
        this.id = id;
        this.name  = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
