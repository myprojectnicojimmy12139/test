package com.flinkinfo.eplus.api.service.product;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 获取分类筛选列表
 *
 * @author nico
 */
@Component
public class CategoryService implements ServiceHandler
{

    @Override
    public String supportServiceName() {
        return "option.category";
    }

    @Override
    public Response handle(Request request) throws Exception {
        //假数据
        List<Category> categories = new ArrayList<>();
        String []categorylist = new String[]{
                "法律服务","财税服务","审计服务",
                "金融服务","调查服务","咨询服务",
                "法律服务","财税服务","审计服务",
                "金融服务","调查服务","咨询服务"
        };
        for(int i=0;i<categorylist.length;i++) {
            Category category = new Category(i+1,categorylist[i]);
            categories.add(category);
        }

        //返回参数
        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String,Object>()
        {
            {
                put("categories",categories);
                put("totalPage",1);
            }
        });
        return response;
    }
}
