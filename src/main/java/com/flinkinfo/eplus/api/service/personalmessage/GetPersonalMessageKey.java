package com.flinkinfo.eplus.api.service.personalmessage;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetPersonalMessageKey implements ServiceHandler
{
    @Override
    public String supportServiceName() {
        return "personal_message.personal_reply_list_key";
    }

    @Override
    public Response handle(Request request) throws Exception {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        Long userId = (Long) params.get("user_id");
        Long linkmanId = (Long) params.get("linkman_id");

        if(userId != null && linkmanId != null)
        {
            response.setStatus(Response.STATUS_SUCCESS);
            response.setContent(new HashMap<String, Object>()
            {
                {
                    put("secret_key", "22544fff");
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
