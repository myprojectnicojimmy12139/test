package com.flinkinfo.eplus.api.service.user;


import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ModifyPasswordService  implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "user.update_password";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String oldPassword = (String) params.get("old_password");
        String newPassword = (String) params.get("new_password");

        if((Integer) params.get("user_id") != null && oldPassword != null && newPassword != null)
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
