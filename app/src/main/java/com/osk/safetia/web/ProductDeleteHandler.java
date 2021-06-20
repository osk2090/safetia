package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductDeleteHandler {
    ProductService productService;

    public ProductDeleteHandler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/delete")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));

        Product p = productService.get(no);
        if (p == null) {
            throw new Exception("해당 번호의 제품이 없습니다.");
        }

        productService.delete(no);

        return "redirect:list";
    }
}
