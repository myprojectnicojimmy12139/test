package com.flinkinfo.eplus.api.service.user;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class RegisterService implements ServiceHandler
{

    private User user;

    @Override
    public String supportServiceName() {
        return "user.register";
    }

    @Override
    public Response handle(Request request) throws Exception {

        Response response = new Response();

        Map<String, Object> params = request.getParams();
        String phone = (String) params.get("phone");
        String code = (String) params.get("code");
        String password = (String) params.get("password");

        if(phone != null && code != null && password != null)
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
