package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jan on 15/8/4.
 */
public class Token
{
    @JSONField(name = "code")
    private int code;

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "token")
    private String token;

    public Token(int code,String userId,String token)
    {
        this.code = code;
        this.userId = userId;
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
