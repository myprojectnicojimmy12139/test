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

/**
 * 获取服务详情
 *
 * @author nico
 */
@Component
public class ProductDetailService implements ServiceHandler {

    @Override
    public String supportServiceName() {
        return "product.detail";
    }

    @Override
    public Response handle(Request request) throws Exception {
        //请求参数
        Map<String, Object> params = request.getParams();
        int product_id = (Integer) params.get("product_id");

        //假数据
        String[] area = new String[]{"广东", "云南", "北京", "四川"};
        int page = product_id % 10;
        if(page  == 0)
        {
            page = 10;
        }
        int area_index = product_id % 4;
        String[] categorylist = new String[]{
                "法律服务", "财税服务", "审计服务",
                "金融服务", "调查服务", "咨询服务",
                "法律服务", "财税服务", "审计服务",
                "金融服务", "调查服务", "咨询服务"
        };
        String[] imgurl = new String[]{
                "http://img3.3lian.com/2013/9/11/d/81.jpg",
                "http://img5.imgtn.bdimg.com/it/u=78434552,1564828281&fm=23&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=3015001919,2482592399&fm=21&gp=0.jpg",
                "http://img3.3lian.com/2013/c4/14/d/11.jpg",
                "http://img3.3lian.com/2013/9/11/d/81.jpg",
                "http://img5.imgtn.bdimg.com/it/u=78434552,1564828281&fm=23&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=3015001919,2482592399&fm=21&gp=0.jpg",
                "http://img3.3lian.com/2013/c4/14/d/11.jpg",
                "http://img3.3lian.com/2013/9/11/d/81.jpg",
                "http://img5.imgtn.bdimg.com/it/u=78434552,1564828281&fm=23&gp=0.jpg"
        };
        Category category = new Category(page, categorylist[page]);
        Product product = new Product(product_id, "企业尽职调查服务" + product_id, "5" + product_id, "这就是一个5"+product_id+"万元的服务", imgurl[page-1], category);

        String introduce = "本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务";
        String introduce1 = "本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的" +
                "企业精致调查服务本产品主要为企业提供专业的企业精致调查服务本产品主要为企业提供专业的企业精致调查服务";
        String []introducelist = new String[]{introduce,introduce1};
        ProductDetail productDetail = new ProductDetail(product_id,product,introducelist[product_id%2] , area[area_index], product_id + 1);

        //返回参数
        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>() {
            {
                put("product_detail", productDetail);
            }
        });
        return response;
    }
}
