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
        List<Product> list = productService.list();
        request.setAttribute("list", list);
        return "/jsp/product/list.jsp";
    }
}
