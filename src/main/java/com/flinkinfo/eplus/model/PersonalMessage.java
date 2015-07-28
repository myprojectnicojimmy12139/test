package com.flinkinfo.eplus.model;


import com.alibaba.fastjson.annotation.JSONField;

public class PersonalMessage
{
    @JSONField(name = "id")
    private int id;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "create_datetime")
    private String createDatetime;

    @JSONField(name = "is_read")
    private Boolean isRead;

    @JSONField(name = "sender")
    private User sender;

    @JSONField(name = "receiver")
    private User receiver;

    public int getId() {
        return id;
    }


    public PersonalMessage(int id,String content,String createDatetime,Boolean isRead,User sender,User receiver)
    {
        this.id = id;
        this.content = content;
        this.createDatetime = createDatetime;
        this.isRead = isRead;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }
}
