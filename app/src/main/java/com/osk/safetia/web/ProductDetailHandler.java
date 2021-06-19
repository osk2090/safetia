package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductDetailHandler {
    ProductService productService;

    public ProductDetailHandler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/detail")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));

        Product p = productService.get(no);
        request.setAttribute("product", p);
        return "/jsp/product/detail.jsp";
    }
}
