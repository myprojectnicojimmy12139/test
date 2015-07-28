package com.flinkinfo.eplus.model;

import com.alibaba.fastjson.annotation.JSONField;

/**获取服务详情
 * Created on 15/7/27.
 * @author nico
 */
public class ProductDetail {
    //服务详情id
    @JSONField(name = "id")
    private int id;

    //服务
    @JSONField(name = "service")
    private Product service;

    //服务介绍
    @JSONField(name = "introduce")
    private String introduce;

    //地区
    @JSONField(name = "area")
    private String area;

    //提供服务机构数量
    @JSONField(name = "organizationNumber")
    private int organization_number;

    public ProductDetail(int id, Product service, String introduce, String area, int organization_number)
    {
        this.id = id;
        this.service = service;
        this.introduce = introduce;
        this.area = area;
        this.organization_number = organization_number;
    }

    public int getId() {
        return id;
    }

    public Product getService() {
        return service;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getArea() {
        return area;
    }

    public int getOrganization_number() {
        return organization_number;
    }
}
