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

/**获取分类筛选列表
 * Created on 15/7/27.
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
        for(int i=0;i<10;i++) {
            Category category = new Category(i,"服务"+i);
            categories.add(category);
        }

        //返回参数
        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String,Object>()
        {
            {
                put("categories",categories);
                put("totalPage",5);
            }
        });
        return response;
    }
}
