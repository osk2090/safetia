package com.osk.safetia.service.impl;

import com.osk.safetia.dao.ProductDao;
import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    //제품등록
    @Override
    public int add(Product product) throws Exception {
        return productDao.insert(product);
    }

    //제품목록조회
    @Override
    public List<Product> list() throws Exception {
        return productDao.findByModel(null);
    }

    //제품 상세 조회
    @Override
    public Product get(int no) throws Exception {
        Product product = productDao.findByNo(no);
        return product;
    }

    //제품 변경
    @Override
    public int update(Product product) throws Exception {
        return productDao.update(product);
    }

    //제품 검색
    @Override
    public List<Product> search(String keyword) throws Exception {
        return productDao.findByModel(keyword);
    }
}
