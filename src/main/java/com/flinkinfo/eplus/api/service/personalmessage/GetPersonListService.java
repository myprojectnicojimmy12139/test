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
        return "personal_message.contacts";
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
                 user = new User(1234,"Jimmy","男","nico","fulin","boss","10086","afoehwoaf@163.com",new ArrayList<String>(){
                    {
                        add("www.baidu.com");
                        add("www.sina.com");
                    }
                });
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
