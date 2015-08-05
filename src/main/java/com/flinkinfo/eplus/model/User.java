package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class User implements Serializable
{
    @JSONField(name = "id")
    private int id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "english_name")
    private String english_name;

    @JSONField(name = "institutions")
    private String institutions;

    @JSONField(name = "position")
    private String position;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "header_image")
    Map<String,String> headerImage;


    public User(int id , String name , String gender,String english_name,
                String institutions, String position,String mobile,String email,Map<String,String> headerImage)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.english_name = english_name;
        this.institutions = institutions;
        this.position = position;
        this.mobile = mobile;
        this.email = email;
        this.headerImage = headerImage;
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

    public String getEnglish_name() {
        return english_name;
    }

    public String getInstitutions() {
        return institutions;
    }

    public String getPosition() {
        return position;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Map<String,String> getHeaderImage() {
        return headerImage;
    }
}
