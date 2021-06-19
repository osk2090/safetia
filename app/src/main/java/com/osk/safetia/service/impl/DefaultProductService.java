package com.osk.safetia.service.impl;

import com.osk.safetia.dao.ProductDao;
import com.osk.safetia.domain.Product;
import com.osk.safetia.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

@Service
public class DefaultProductService implements ProductService {

    TransactionTemplate transactionTemplate;

    ProductDao productDao;

    public DefaultProductService(PlatformTransactionManager transactionTemplate, ProductDao productDao) {
        this.transactionTemplate = new TransactionTemplate(transactionTemplate);
        this.productDao = productDao;
    }

    //제품등록
    @Override
    public int add(Product product) throws Exception {

        return transactionTemplate.execute(new TransactionCallback<Integer>(){
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                try {
                    return productDao.insert(product);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
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
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                try {
                    return productDao.update(product);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    //제품 검색
    @Override
    public List<Product> search(String keyword) throws Exception {
        return productDao.findByModel(keyword);
    }

    @Override
    public int delete(int no) throws Exception {
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                try {
                    return productDao.delete(no);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    ///////////////////////////////

    @Override
    public int addWithProduct1(Map<String, Object> params) throws Exception {
        return productDao.insertSus01(params);
    }

    @Override
    public List<Product> list01() throws Exception {
        return productDao.findByModel(null);
    }

    @Override
    public int addWithProduct2(Map<String, Object> params) throws Exception {
        return productDao.insertSus02(params);
    }

    @Override
    public List<Product> list02(Map<String, Object> params) throws Exception {
        return productDao.findByModel(null);
    }
}
