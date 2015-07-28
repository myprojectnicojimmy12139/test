package com.flinkinfo.eplus.api.service.user;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FetchMobileCode implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "user.fetch_mobile_code";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String phone = (String) params.get("phone");
        String type = (String) params.get("type");
        if(phone != null){
                if(type != null)
                {
                    if(type.equals("register"))
                    {
                        response.setStatus(Response.STATUS_SUCCESS);
                        response.setContent(new HashMap<String, Object>()
                        {
                            {
                                put("register_code", "123456");
                            }
                        });
                    }
                    else
                    {
                        if(type.equals("password_reset"))
                        {
                            response.setStatus(Response.STATUS_SUCCESS);
                            response.setContent(new HashMap<String, Object>()
                            {
                                {
                                    put("password_code", "789101");
                                }
                            });
                        }
                        else
                        {
                            response.setStatus(Response.STATUS_FAILURE);
                        }
                    }
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
