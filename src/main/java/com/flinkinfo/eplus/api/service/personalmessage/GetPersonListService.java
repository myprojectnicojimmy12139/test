package com.flinkinfo.eplus.api.service.personalmessage;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class GetPersonListService implements ServiceHandler
{

    private User user;

    private ArrayList<User> users;

    @Override
    public String supportServiceName()
    {
        return "personnal_message.contacts";
    }

    @Override
    public Response handle(Request request) throws Exception
    {

        Response response = new Response();
        Map<String, Object> params = request.getParams();
        Long userId = (Long) params.get("user_id");
        System.out.print(userId);
        users = new ArrayList<>();

        if(userId != null)
        {
            for(int i = 0;i < 10 ; i++)
            {
                user = new User(i,"Jimmy","男","15902078327","523160615@qq.com","广州市越秀区",new ArrayList<String>(){
                    {
                        add("www.baidu.com");
                        add("www.sina.com");
                    }
                },"这是一个简介");
                users.add(user);
            }
            response.setStatus(Response.STATUS_SUCCESS);
            response.setContent(new HashMap<String, Object>()
            {
                {
                    put("contacts", users);
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
