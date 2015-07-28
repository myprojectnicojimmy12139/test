package com.flinkinfo.eplus.api.service.personalmessage;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.PersonalMessage;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class GetMessageListService implements ServiceHandler
{
    private User user;

    private PersonalMessage personalMessage;

    @Override
    public String supportServiceName()
    {
        return "personnal_message.msg_list";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        Long userId = (Long) params.get("user_id");
        int page;
        if(params.get("page") != null)
        {
            page = (int) params.get("page");
        }
        else
        {
            page = -1;
        }

        ArrayList<PersonalMessage> personalMessages = new ArrayList<>();

        user = new User(1234,"Jimmy","男","15902078327","523160615@qq.com","广州市越秀区",new ArrayList<String>(){
            {
                add("www.baidu.com");
                add("www.sina.com");
            }
        },"这是一个简介");

        for (int i = 0; i < 10 ; i ++)
        {
            personalMessage = new PersonalMessage(i,"这是私信内容","10998383838",true,user,user);
            personalMessages.add(personalMessage);
        }

        if(userId != null && page != -1)
        {
            response.setStatus(Response.STATUS_SUCCESS);
            response.setContent(new HashMap<String, Object>()
            {
                {
                    put("messages", personalMessages);
                    put("totalPage", 5);
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
