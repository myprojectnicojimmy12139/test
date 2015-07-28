package com.flinkinfo.eplus.api.service.product;

import com.flinkinfo.eplus.api.Request;
import com.flinkinfo.eplus.api.Response;
import com.flinkinfo.eplus.api.ServiceHandler;
import com.flinkinfo.eplus.model.Category;
import com.flinkinfo.eplus.model.Product;
import com.flinkinfo.eplus.model.ProductDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**获取服务详情
 * Created on 15/7/27.
 * @author nico
 */
@Component
public class ProductDetailService implements ServiceHandler
{

    @Override
    public String supportServiceName() {
        return "product.detail";
    }

    @Override
    public Response handle(Request request) throws Exception {
        //请求参数
        Map<String ,Object> params = request.getParams();
        int product_id = (Integer)params.get("product_id");

        //假数据
        String []area = new String[]{"广东","云南","北京","四川"};
        int page = product_id/10+1;
        int area_index = product_id%4;

        List<Product> products = new ArrayList<>();
        for (int i = 10 * (page - 1), j = 0; i < 10 * page; i++, j++) {
            Category category = new Category(j, "服务" + j);
            Product service = new Product(i, "xx服务" + i,5, "这就是一个5万元的服务", "http://img3.3lian.com/2013/9/11/d/81.jpg", category);
            products.add(service);
        }
       ProductDetail productDetail = new ProductDetail(product_id,products.get(product_id%10),"我是服务介绍",area[area_index],14);

        //返回参数
        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("productDetail", productDetail);
            }
        });
        return response;
    }
}
