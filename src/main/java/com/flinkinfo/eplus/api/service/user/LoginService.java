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
public class LoginService implements ServiceHandler
{
    @Override
    public String supportServiceName() {
        return "user.login";
    }

    @Override
    public Response handle(Request request) throws Exception {

        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String subject = (String) params.get("subject");
        String password = (String) params.get("password");

        if(subject != null )
        {
            if(password != null)
            {
                User user = new User(1234,"Jimmy","男",subject,"523160615@qq.com","广州市越秀区",new ArrayList<String>(){
                    {
                        add("www.baidu.com");
                        add("www.sina.com");
                    }
                },"这是一个简介");

                response.setStatus(Response.STATUS_SUCCESS);
                response.setContent(new HashMap<String, Object>()
                {
                    {
                        put("user",user);
                    }
                });
            }
            else
            {
                response.setStatus(Response.STATUS_FAILURE);
            }
        }
        else
        {
            response.setStatus(Response.STATUS_FAILURE);
        }
        return response;
    }
}
