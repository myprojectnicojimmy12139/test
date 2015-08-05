package com.flinkinfo.eplus.api.service.info;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.model.ServiceInfo;
import com.flinkinfo.eplus.model.SystemInform;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 15/8/4.
 */
@Component
public class SysteminformService implements ServiceHandler {

    @Override
    public String supportServiceName() {
        return "info.systeminform";
    }

    @Override
    public Response handle(Request request) throws Exception {
        Map<String, Object> params = request.getParams();
        //企业用户ID
        int user_id = (Integer) params.get("user_id");
        //服务通知ID
        int system_inform_id = (Integer) params.get("system_inform_id");
        int id = system_inform_id%4;

        List<SystemInform> systemInformList = new ArrayList<>();

        SystemInform systemInform = new SystemInform(1,"系统提示您，您的服务请求已经被受理！！",System.currentTimeMillis()+"",false);
        SystemInform systemInform1 = new SystemInform(2,"系统提示您，您的服务请求被拒绝！！",System.currentTimeMillis()+"",false);
        SystemInform systemInform2 = new SystemInform(3,"系统提示您，您的服务马上要到期了！！",System.currentTimeMillis()+"",false);
        SystemInform systemInform3 = new SystemInform(4,"系统提示您，您的金融服务已经完成，谢谢您的信赖！！",System.currentTimeMillis()+"",false);

        systemInformList.add(systemInform);
        systemInformList.add(systemInform1);
        systemInformList.add(systemInform2);
        systemInformList.add(systemInform3);

        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("system_info",systemInformList.get(id));
            }
        });
        return response;
    }
}
