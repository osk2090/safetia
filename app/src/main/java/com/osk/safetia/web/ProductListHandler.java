package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductListHandler {
    ProductService productService;

    public ProductListHandler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Product> products = null;
        if (keyword != null && keyword.length() > 0) {
            products = productService.search(keyword);
        } else {
            products = productService.list();
        }

        List<Product> products01 = productService.list01();

        request.setAttribute("isList01", products01);
        request.setAttribute("list", products);
        return "/jsp/product/list.jsp";
    }
}
