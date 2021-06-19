package com.osk.safetia.dao;

import com.osk.safetia.domain.Product;

import java.util.List;

// BoardDao 의 규칙 정의
public interface ProductDao {

  int insert(Product product) throws Exception;

  List<Product> findByModel(String keyword) throws Exception;

  Product findByNo(int no) throws Exception;

  int update(Product board) throws Exception;

}












