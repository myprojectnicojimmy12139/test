package com.flinkinfo.eplus.api.service.user;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class RegisterService implements ServiceHandler
{

    private User user;

    @Override
    public String supportServiceName() {
        return "user.register";
    }

    @Override
    public Response handle(Request request) throws Exception {

        Response response = new Response();

        Map<String, Object> params = request.getParams();
        String phone = (String) params.get("phone");
        String code = (String) params.get("code");
        String password = (String) params.get("password");

        if(phone != null && code != null && password != null)
        {
             user = new User(1234,"Jimmy","男","nico","fulin","boss","10086","afoehwoaf@163.com",new ArrayList<String>(){
                {
                    add("www.baidu.com");
                    add("www.sina.com");
                }
            });

            response.setStatus(Response.STATUS_SUCCESS);
            response.setContent(new HashMap<String, Object>()
            {
                {
                    put("user",user);
                    put("message", "show me the money");
                }
            });
        }
        else
        {
            response.setStatus(Response.STATUS_FAILURE);
        }
        return response;
    }
}
