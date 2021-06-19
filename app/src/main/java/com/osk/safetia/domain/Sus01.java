package com.osk.safetia.domain;

import java.util.List;

public class Sus01 {
    private int no;
    private List<Product> products;

    @Override
    public String toString() {
        return "Sus01{" +
                "no=" + no +
                ", products=" + products +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
