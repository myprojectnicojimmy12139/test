package com.flinkinfo.eplus.api.service.personalmessage;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetPersonMessageList implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "personnal_message.personal_reply_list";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        Long userId = (Long) params.get("user_id");
        Long linkmanId = (Long) params.get("linkman_id");
        String secretKey = (String) params.get("secret_key");

        if(userId != 1 && linkmanId != 1 && secretKey != null)
        {
            response.setStatus(Response.STATUS_SUCCESS);
            response.setContent(new HashMap<String, Object>()
            {
                {
                    put("url", "http://www.163.com/");
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
