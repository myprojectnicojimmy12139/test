package com.flinkinfo.eplus.model;


import com.alibaba.fastjson.annotation.JSONField;

public class AppVersionInfo
{
    @JSONField(name = "version")
    private String version;

    @JSONField(name = "summary")
    private String summary;

    @JSONField(name = "updateUrl")
    private String updateUrl;

    public AppVersionInfo(String version , String summary , String updateUrl)
    {
        this.version = version;
        this.summary = summary;
        this.updateUrl = updateUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getSummary() {
        return summary;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }
}
