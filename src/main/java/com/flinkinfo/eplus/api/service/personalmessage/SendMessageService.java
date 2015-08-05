package com.flinkinfo.eplus.api.service.personalmessage;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SendMessageService implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "personal_message.send";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String content = (String) params.get("content");

        if(content != null && (Integer) params.get("receiver_id") != null && (Integer) params.get("sender_id") != null)
        {
            response.setStatus(Response.STATUS_SUCCESS);
        }
        else
        {
            response.setStatus(Response.STATUS_FAILURE);
        }

        return response;
    }
}
