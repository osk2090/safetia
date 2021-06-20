package com.osk.safetia.service;

import com.osk.safetia.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int add(Product product) throws Exception;

    List<Product> list() throws Exception;

    Product get(int no) throws Exception;

    int update(Product product) throws Exception;

    List<Product> search(String keyword) throws Exception;

    int delete(int no) throws Exception;


    int addWithProduct1(Map<String, Object> params) throws Exception;

    List<Product> list01() throws Exception;

    int addWithProduct2(Map<String, Object> params) throws Exception;

    List<Product> list02() throws Exception;
}
