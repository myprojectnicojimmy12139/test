package com.flinkinfo.eplus.api.service.user;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResetPasswordService implements ServiceHandler
{
    @Override
    public String supportServiceName() {
        return "user.reset_password";
    }

    @Override
    public Response handle(Request request) throws Exception {

        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String phone = (String) params.get("phone");
        String password = (String) params.get("password");

        if(phone != null && password != null)
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
