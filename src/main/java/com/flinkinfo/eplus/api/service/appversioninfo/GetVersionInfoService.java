package com.flinkinfo.eplus.api.service.appversioninfo;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.AppVersionInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GetVersionInfoService implements ServiceHandler {
    @Override
    public String supportServiceName() {
        return "update.version";
    }

    @Override
    public Response handle(Request request) throws Exception {

        AppVersionInfo appVersionInfo = new AppVersionInfo("1.0","此版增加了新功能","http://www.baidu.com");

        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>()
        {
            {
                put("app", appVersionInfo);
            }
        });
        return response;
    }
}
