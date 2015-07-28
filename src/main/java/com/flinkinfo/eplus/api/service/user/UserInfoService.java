package com.flinkinfo.eplus.api.service.user;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取服务列表
 * Created on 15/7/27
 *
 * @author nico
 */
@Component
public class UserInfoService implements ServiceHandler {

    @Override
    public String supportServiceName() {
        return "user_info.figure";
    }

    @Override
    public Response handle(Request request) throws Exception {
        //请求参数
        Map<String, Object> params = request.getParams();
        int user_id = (Integer)params.get("user_id");

        //假数据
        List<UserInfo> userInfos = new ArrayList<>();
        for(int i=0;i<=user_id;i++)
        {
            UserInfo userInfo = new UserInfo(i+1,i+2,i+4,i);
            userInfos.add(userInfo);
        }

        //返回参数
        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("unread_message", userInfos.get(user_id).getUnreadMessage());
                put("unread_system_inform_number", userInfos.get(user_id).getUnreadSystemInformNumber());
                put("unread_service_inform_number", userInfos.get(user_id).getUnreadServiceInformNumber());
            }
        });
        return response;
    }
}
