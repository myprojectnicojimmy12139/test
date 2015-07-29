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
        return "personal_message.msg_list";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        Response response = new Response();
        Map<String, Object> params = request.getParams();
        int userId = (Integer) params.get("user_id");
        if ((Integer) params.get("user_id") == null)
        {

        }
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

        user = new User(1234,"Jimmy","男","nico","fulin","boss","10086","afoehwoaf@163.com",new ArrayList<String>(){
            {
                add("www.baidu.com");
                add("www.sina.com");
            }
        });

        for (int i = 0; i < 10 ; i ++)
        {
            personalMessage = new PersonalMessage(i,"这是私信内容","10998383838",true,user,user);
            personalMessages.add(personalMessage);
        }

        if(userId==1  && page != -1)
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
