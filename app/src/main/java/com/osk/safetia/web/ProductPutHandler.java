package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class ProductPutHandler {
    ProductService productService;

    public ProductPutHandler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/put")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));

        HashMap<String, Object> params = new HashMap<>();
        params.put("productNo", no);

        //동시에 넣기
        System.out.println("1111111");
        productService.addWithProduct1(params);
        productService.addWithProduct2(params);
        System.out.println("222222");

        return "redirect:list";
    }
}
