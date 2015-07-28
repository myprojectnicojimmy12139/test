package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable
{
    @JSONField(name = "id")
    private int id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "address")
    private String address;

    @JSONField(name = "header_image")
    List<String> headerImage;

    @JSONField(name = "summary")
    private String summary;


    public User(int id , String name , String gender , String mobile , String email , String address , List<String> headerImage , String summary)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.headerImage = headerImage;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getHeaderImage() {
        return headerImage;
    }

    public String getSummary() {
        return summary;
    }
}
