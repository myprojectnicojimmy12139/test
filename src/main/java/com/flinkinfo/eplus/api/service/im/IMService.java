package com.flinkinfo.eplus.api.service.im;

import com.alibaba.fastjson.JSONObject;
import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.Token;
import com.flinkinfo.eplus.rong.ApiHttpClient;
import com.flinkinfo.eplus.rong.models.FormatType;
import com.flinkinfo.eplus.rong.models.SdkHttpResult;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 15/8/4.
 */
@Component
public class IMService implements ServiceHandler {

    @Override
    public String supportServiceName() {
        return "im.token";
    }

    @Override
    public Response handle(Request request) throws Exception {
//        int userId = (Integer)request.getParams("user_id");
//        String userName = (String)request.getParams("user_name");
//        String portraitUri = (String)request.getParams("portrait_uri");

        String key = "pwe86ga5elmc6";
        String secret = "YKwmFn2HTWM";

        SdkHttpResult result = ApiHttpClient.getToken(key, secret, "402880ef4a", "asdfa",
                "http://aa.com/a.png", FormatType.json);
        Response response = new Response();
        Gson gson = new Gson();
        Token myToken = gson.fromJson(result.getResult(),Token.class);
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("token",myToken);
            }
        });
        return response;
    }
}
