package com.flinkinfo.eplus.model;


import com.alibaba.fastjson.annotation.JSONField;

public class UserInfo
{
    @JSONField(name = "user_id")
    private int user_id;

    @JSONField(name = "unread_system_inform_number")
    private int unreadSystemInformNumber;


    @JSONField(name = "unread_service_inform_number")
    private int unreadServiceInformNumber;

    @JSONField(name = "unread_message")
    private int unreadMessage;

    public  UserInfo(int unreadSystemInformNumber,int unreadServiceInformNumber,int unreadMessage,int user_id )
    {
        this.unreadSystemInformNumber = unreadSystemInformNumber;
        this.unreadServiceInformNumber = unreadServiceInformNumber;
        this.unreadMessage = unreadMessage;
        this.user_id = user_id;
    }

    public int getUnreadSystemInformNumber() {
        return unreadSystemInformNumber;
    }

    public int getUnreadServiceInformNumber() {
        return unreadServiceInformNumber;
    }

    public int getUnreadMessage() {
        return unreadMessage;
    }

    public int getUser_id() {
        return user_id;
    }
}
