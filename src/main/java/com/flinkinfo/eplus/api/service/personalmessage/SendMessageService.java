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
        return "personnal_message.send";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String content = (String) params.get("content");
        Long receiverId = (Long) params.get("receiver_id");
        Long senderId = (Long) params.get("sender_id");

        if(content != null && receiverId != null && senderId != null)
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
