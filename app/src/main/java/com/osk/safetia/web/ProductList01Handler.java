package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductList01Handler {
    ProductService productService;

    public ProductList01Handler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list01")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.list01();

        request.setAttribute("list01", products);

        return "/jsp/product/list01.jsp";
    }
}
