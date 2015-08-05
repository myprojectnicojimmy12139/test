package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.flinkinfo.eplus.model.ServiceInfo;

/**
 * Created by jan on 15/8/4.
 */
public class ServiceInform {

    @JSONField(name = "id")
    private int id;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "create_datetime")
    private String create_datetime;

    @JSONField(name = "service")
    private ServiceInfo serviceInfo;

    @JSONField(name = "is_read")
    private boolean is_read;


    public ServiceInform(int id,String content,String create_datetime,ServiceInfo serviceInfo,boolean is_read){
        this.id = id;
        this.content = content;
        this.create_datetime = create_datetime;
        this.serviceInfo = serviceInfo;
        this.is_read = is_read;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreate_datetime() {
        return create_datetime;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public boolean is_read() {
        return is_read;
    }
}
