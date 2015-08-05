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
public class LoginService implements ServiceHandler
{
    @Override
    public String supportServiceName() {
        return "user.login";
    }

    @Override
    public Response handle(Request request) throws Exception {

        Response response = new Response();
        Map<String, Object> params = request.getParams();
        String subject = (String) params.get("subject");
        String password = (String) params.get("password");
        Map<String,String> map = new HashMap<>();
        map.put("thirty","http://img5q.duitang.com/uploads/item/201506/05/20150605140809_CxZPt.jpeg");
        map.put("fifty","http://imgq.duitang.com/uploads/item/201410/06/20141006151406_HssfQ.png");
        map.put("one_hundred","http://file-www.sioe.cn/201109/14/222211817.jpg");
        map.put("two_hundred","http://imgq.duitang.com/uploads/item/201410/06/20141006151406_HssfQ.png");
        map.put("original","http://p3.gexing.com/G1/M00/C0/F7/rBACE1Ojp7iDJJzTAAAWMzSlqR0708_200x200_3.jpg?recache=20131108");



        if(subject != null )
        {
            if(password != null)
            {
                User user = new User(1234,"Jimmy","男","nico","fulin","boss","10086","afoehwoaf@163.com",map);

                response.setStatus(Response.STATUS_SUCCESS);
                response.setContent(new HashMap<String, Object>()
                {
                    {
                        put("user",user);
                    }
                });
            }
            else
            {
                response.setStatus(Response.STATUS_FAILURE);
            }
        }
        else
        {
            response.setStatus(Response.STATUS_FAILURE);
        }
        return response;
    }
}
