package com.osk.safetia.service;

import com.osk.safetia.domain.Product;

import java.util.List;

public interface ProductService {
    int add(Product product) throws Exception;

    List<Product> list() throws Exception;

    Product get(int no) throws Exception;

    int update(Product product) throws Exception;

    List<Product> search(String keyword) throws Exception;
}
