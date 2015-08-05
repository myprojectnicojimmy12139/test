package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jan on 15/8/4.
 */
public class ServiceInfo {

    @JSONField(name = "id")
    private int id;

    @JSONField(name = "logo_url")
    private String logo_url;

    @JSONField(name = "service_name")
    private String service_name;

    @JSONField(name = "service_type")
    private String service_type;

    @JSONField(name = "service_institution")
    private String service_institution;

    @JSONField(name = "order_status")
    private String order_status;


    public ServiceInfo(int id, String logo_url, String service_name, String service_type, String service_institution, String order_status){
        this.id = id;
        this.logo_url = logo_url;
        this.service_name = service_name;
        this.service_type = service_type;
        this.service_institution = service_institution;
        this.order_status = order_status;
    }

    public int getId() {
        return id;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public String getService_name() {
        return service_name;
    }

    public String getService_type() {
        return service_type;
    }

    public String getService_institution() {
        return service_institution;
    }

    public String getOrder_status() {
        return order_status;
    }
}
