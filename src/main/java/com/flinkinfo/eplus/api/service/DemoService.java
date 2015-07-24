package com.flinkinfo.eplus.api.service;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DemoService implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "demo";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        User user = new User("kut", 100, new ArrayList<String>()
        {
            {
                add("shosldll");
                add("lsllslsslslsl");
            }
        });

        List<User> users = new ArrayList<>();
        users.add(user);

        user = new User("kut", 100, new ArrayList<String>()
        {
            {
                add("shosldll");
                add("lsllslsslslsl");
            }
        });
        users.add(user);


        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>()
        {
            {
                put("users", users);
                put("message", "show me the money");
            }
        });
        return response;
    }
}
