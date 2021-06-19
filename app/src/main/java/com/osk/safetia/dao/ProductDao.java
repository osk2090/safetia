package com.osk.safetia.dao;

import com.osk.safetia.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductDao {

  int insert(Product product) throws Exception;

  List<Product> findByModel(String keyword) throws Exception;

  Product findByNo(int no) throws Exception;

  int update(Product board) throws Exception;

  int delete(int no) throws Exception;

  //////////////////////////////////

  int insertSus01(Map<String, Object> params) throws Exception;

  int insertSus02(Map<String, Object> params) throws Exception;

  List<Product> findSus01(int productNo) throws Exception;

  List<Product> findSus02(int productNo) throws Exception;
}