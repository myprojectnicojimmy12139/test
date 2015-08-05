package com.flinkinfo.eplus.api.service.personalmessage;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.PersonalMessage;
import com.flinkinfo.eplus.model.User;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int page;
        if(params.get("page") != null)
        {
            page = (int) params.get("page");
        }
        else
        {
            page = -1;
        }
        List<Map<String,String>> list = new ArrayList<>();
        ArrayList<PersonalMessage> personalMessages = new ArrayList<>();

        String []nameList =  new String[]{"张国荣","黄晓明","范冰冰","刘亦菲","张学友","李白","张先生","罗女士","张三","李四",};
        String []gender =  new String[]{"男","男","女","女","男","男","男","女","男","男"};
        String []english_name = new String[]{"a","b","c","d","e","f","g","h","i","j"};
        String []institutions = new String[]{"广东红星律师事务所","广东白星财务局","广东金星审计局",
                "广东绿星金融中心","广东黄星调查事务所","广东紫星咨询中心","广东白星财务局","广东金星审计局",
                "广东绿星金融中心","广东黄星调查事务所"};
        String []content = new String[]{"呵呵","明天见","好的","中午","请放心","我后天有时间","我不确定","到时候再说","哦","嗯"};
        String []one_hundred = new String[]{
                "http://file-www.sioe.cn/201109/14/222211817.jpg",
                "http://img3.imgtn.bdimg.com/it/u=2117727038,2641018931&fm=21&gp=0.jpg",
                "http://img.store.sogou.com/net/a/05/link?appid=100520033&url=http%3A%2F%2Fwww.qqw21.com%2Farticle%2FUploadPic%2F2012-10%2F201210229441110298.jpg",
                "http://img4.duitang.com/uploads/item/201401/13/20140113200216_Se2xe.thumb.600_0.jpeg",
                "http://www.qqzhi.com/uploadpic/2014-09-05/160840259.jpg",
                "http://img5q.duitang.com/uploads/item/201506/29/20150629222217_mz5RF.jpeg",
                "http://file-www.sioe.cn/201109/14/222211817.jpg",
                "http://img3.imgtn.bdimg.com/it/u=2117727038,2641018931&fm=21&gp=0.jpg",
                "http://img.store.sogou.com/net/a/05/link?appid=100520033&url=http%3A%2F%2Fwww.qqw21.com%2Farticle%2FUploadPic%2F2012-10%2F201210229441110298.jpg",
                "http://img1.3lian.com/img13/c4/55/d/1.jpg",
        };
        for(int i=0;i<10;i++)
        {
            Map<String,String> map = new HashMap<>();
            map.put("thirty","http://img5q.duitang.com/uploads/item/201506/05/20150605140809_CxZPt.jpeg");
            map.put("fifty","http://imgq.duitang.com/uploads/item/201410/06/20141006151406_HssfQ.png");
            map.put("two_hundred","http://imgq.duitang.com/uploads/item/201410/06/20141006151406_HssfQ.png");
            map.put("original","http://p3.gexing.com/G1/M00/C0/F7/rBACE1Ojp7iDJJzTAAAWMzSlqR0708_200x200_3.jpg?recache=20131108");
            map.put("one_hundred",one_hundred[i]);
            list.add(map);
        }
        user = new User(1234,"Jimmy","男","nico","fulin","boss","10086","afoehwoaf@163.com",list.get(0));
        for (int i = 0; i < nameList.length ; i ++)
        {
            User user_one = new User(1234+i,nameList[i],gender[i],english_name[i],institutions[i],"boss","10086","afoehwoaf@163.com",list.get(i));
            personalMessage = new PersonalMessage(i,content[i],System.currentTimeMillis()+"",true,user,user_one);
            SimpleDateFormat  date = new SimpleDateFormat("yy - ");
            personalMessages.add(personalMessage);
        }

        if((Integer) params.get("user_id") !=null  && page != -1)
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
