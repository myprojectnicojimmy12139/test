package com.flinkinfo.eplus.api.service.info;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.ServiceInfo;
import com.flinkinfo.eplus.model.ServiceInform;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 15/8/5.
 */
@Component
public class ServiceInformService implements ServiceHandler {

    @Override
    public String supportServiceName() {
        return "info.serviceinform";
    }

    @Override
    public Response handle(Request request) throws Exception {
        Map<String, Object> params = request.getParams();
        //企业用户ID
        int user_id = (Integer) params.get("user_id");
        //服务通知ID
        int service_inform_id = (Integer) params.get("service_inform_id");
        int id = service_inform_id%4;
        List<ServiceInform> serviceList = new ArrayList<>();

        ServiceInfo serviceInfo1 = new ServiceInfo(1, "http://img3.3lian.com/2013/9/11/d/81.jpg", "企业法侓服务", "法侓服务", "广东诚信律师事务所", "服务中");
        ServiceInform serviceInform1 = new ServiceInform(1, "已接受申请",System.currentTimeMillis()+"", serviceInfo1, false);

        ServiceInfo serviceInfo2 = new ServiceInfo(2, "http://img3.3lian.com/2013/9/11/d/81.jpg", "企业税务服务", "税务服务", "广东诚信律师事务所", "已完成");
        ServiceInform serviceInform2 = new ServiceInform(2, "已通过申请",System.currentTimeMillis()+"", serviceInfo2, false);

        ServiceInfo serviceInfo3 = new ServiceInfo(3, "http://img3.3lian.com/2013/9/11/d/81.jpg", "企业尽职调查服务", "调查服务", "广东诚信律师事务所", "服务中");
        ServiceInform serviceInform3 = new ServiceInform(3, "已接受申请",System.currentTimeMillis()+"", serviceInfo3, false);

        ServiceInfo serviceInfo4 = new ServiceInfo(4, "http://img3.3lian.com/2013/9/11/d/81.jpg", "企业金融服务", "金融服务", "广东诚信律师事务所", "已完成");
        ServiceInform serviceInform4 = new ServiceInform(4, "服务已完成",System.currentTimeMillis()+"", serviceInfo4, false);

        serviceList.add(serviceInform1);
        serviceList.add(serviceInform2);
        serviceList.add(serviceInform3);
        serviceList.add(serviceInform4);


        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("service_info",serviceList.get(id));
            }
        });
        return response;
    }
}
