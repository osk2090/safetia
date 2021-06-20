package com.osk.safetia.web;

import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.UUID;

@Controller
public class ProductUpdateHandler {
    ProductService productService;

    public ProductUpdateHandler(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/update")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String uploadDir = request.getServletContext().getRealPath("/upload");
        int no = Integer.parseInt(request.getParameter("no"));

        Product oldProduct = productService.get(no);
        if (oldProduct == null) {
            throw new Exception("해당 번호의 제품이 없습니다.");
        }

        Product p = new Product();
        p.setNo(oldProduct.getNo());
        p.setModel(request.getParameter("model"));
        p.setPrice(Integer.parseInt(request.getParameter("price")));
        p.setCompany(request.getParameter("company"));

        p.setSalt(Integer.parseInt((request.getParameter("salt"))));
        p.setCarbohydrate(Integer.parseInt(request.getParameter("carbohydrate")));
        p.setSugar(Integer.parseInt(request.getParameter("sugar")));
        p.setTransFat(Integer.parseInt(request.getParameter("transFat")));
        p.setSaturatedFat(Integer.parseInt(request.getParameter("saturatedFat")));
        p.setCholesterol(Integer.parseInt(request.getParameter("cholesterol")));
        p.setProtein(Integer.parseInt(request.getParameter("protein")));

        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            photoPart.write(uploadDir + "/" + filename);
            p.setPhoto(filename);

            Thumbnails.of(uploadDir + "/" + filename)
                    .size(30, 30)
                    .outputFormat("jpg")
                    .crop(Positions.CENTER)
                    .toFiles(new Rename() {
                        @Override
                        public String apply(String name, ThumbnailParameter param) {
                            return name + "_30x30";
                        }
                    });

            Thumbnails.of(uploadDir + "/" + filename)
                    .size(80, 80)
                    .outputFormat("jpg")
                    .crop(Positions.CENTER)
                    .toFiles(new Rename() {
                        @Override
                        public String apply(String name, ThumbnailParameter param) {
                            return name + "_80x80";
                        }
                    });
        }
        System.out.println("1");
        productService.update(p);
        System.out.println("2");
        return "redirect:list";
    }
}
