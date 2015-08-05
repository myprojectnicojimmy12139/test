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
 *
 * @author nico
 */
@Component
public class ProductService implements ServiceHandler {
    int totalPage = 1;

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
        int category_id = 0;
        //页数
        int page = (Integer) params.get("page");
        if ((Integer) params.get("arrange") != null) {
            arrange = (Integer) params.get("arrange");
        }
        if ((Integer) params.get("category_id") != null) {
            category_id = (Integer) params.get("category_id");
        }
        //假数据
        List<Product> products = new ArrayList<>();
        List<Product> responseProducts = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
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
        for (int i = 0; i < categorylist.length; i++) {
            Category category = new Category(i + 1, categorylist[i]);
            categoryList.add(category);
        }

        //返回页数数据
        if (page != 0) {
            for (int i = 10 * (page - 1) + 1, j = 0; i <= 10 * page; i++, j++) {
                Product product = new Product(i, "企业尽职调查服务" + i, "5" + i, "这就是一个5" + i + "万元的服务", imgurl[j], categoryList.get(j));
                products.add(product);
            }
        }

        //服务分类为0
        if (category_id == 0) {
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
        }
        //服务分类不为0
        else
        {
            //服务分类
            totalPage = 1;
            List<Product> list = new ArrayList<>();
            //服务分类的全部数据
            for (int i = 0, j = category_id; i < 5; i++)
            {
                Product product = new Product(j, "企业尽职调查服务" + j, "5" + j, "这就是一个5" + j + "万元的服务",imgurl[category_id-1], categoryList.get(category_id - 1));
                list.add(product);
                j = j + 10;
            }
            //排列方式
            switch (arrange) {
                //综合排序
                case 0:
                    for (int i = 0; i < 5; i++) {
                        responseProducts.add(list.get(i));
                    }
                    break;

                case 1:
                    for (int i = list.size() - 1; i >= 0; i--) {
                        responseProducts.add(list.get(i));
                    }
                    break;
                case 2:
                    for (int i = list.size() - 1; i >= list.size() / 2; i--) {
                        responseProducts.add(list.get(i));
                    }
                    for (int i = 0; i < list.size() / 2; i++) {
                        responseProducts.add(list.get(i));
                    }
                    break;
            }
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
