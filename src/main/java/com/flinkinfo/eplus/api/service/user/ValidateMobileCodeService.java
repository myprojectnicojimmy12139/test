package com.flinkinfo.eplus.api.service.user;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidateMobileCodeService implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "user.validate_mobile_code";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String phone = (String) params.get("phone");
        String code = (String) params.get("code");
        String type = (String) params.get("type");

        if(phone != null && code != null && type != null)
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
