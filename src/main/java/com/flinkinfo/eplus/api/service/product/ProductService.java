package com.flinkinfo.eplus.api.service.product;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.Category;
import com.flinkinfo.eplus.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取服务列表
 * Created on 15/7/27
 *
 * @author nico
 */
@Component
public class ProductService implements ServiceHandler {
    int totalPage =1;

    @Override
    public String supportServiceName() {
        return "product.list";
    }

    @Override
    public Response handle(Request request) throws Exception {

        //请求参数
        Map<String, Object> params = request.getParams();
        //排列方式
        int arrange = 0;
        //服务类型
        int category_id = -1;
        //页数
        int page = (Integer) params.get("page");
        if((Integer) params.get("arrange") != null)
        {
            arrange = (Integer) params.get("arrange");
        }
        if((Integer) params.get("category_id") != null) {
            category_id = (Integer) params.get("category_id");
        }
        //假数据
        List<Product> products = new ArrayList<>();
        List<Product> responseProducts = new ArrayList<>();

        //返回页数数据
        if (page != 0) {
            for (int i = 10 * (page - 1), j = 0; i < 10 * page; i++, j++) {
                Category category = new Category(j, "服务" + j);
                Product service = new Product(i, "xx服务" + i,5, "这就是一个5万元的服务", "http://img3.3lian.com/2013/9/11/d/81.jpg", category);
                products.add(service);
            }
        }

        //不是服务分类
        if (category_id == -1) {
            totalPage = 5;
            //排列方式
            switch (arrange) {
                case 0:
                    for (int i = 0; i < 10; i++) {
                        responseProducts.add(products.get(i));
                    }
                    break;
                case 1:
                    for (int i = products.size() - 1; i >= 0; i--) {
                        responseProducts.add(products.get(i));
                    }
                    break;
                case 2:
                    for (int i = products.size() - 1; i >= 5; i--) {
                        responseProducts.add(products.get(i));
                    }
                    for (int i = 0; i < 5; i++) {
                        responseProducts.add(products.get(i));
                    }
                    break;
            }
        } else {//服务分类
            totalPage = 1;
            for (int i = 0, j = category_id; i < 5; i++) {
                Category category = new Category(category_id, "服务" + category_id);
                Product product = new Product(j, "xx服务" + j,5, "这就是一个5万元的服务", "http://img3.3lian.com/2013/9/11/d/81.jpg", category);
                responseProducts.add(product);
                j=j+10;
            }

//            for (int i = 0; i < products.size(); i++) {
//                if (products.get(i).getCategory().getId() == category_id) {
//                    responseProducts.add(products.get(i));
//                }
//            }
        }

        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);

        response.setContent(new HashMap<String, Object>() {
            {
                put("products", responseProducts);
                put("totalPage", totalPage);
            }
        });
        return response;
    }
}
