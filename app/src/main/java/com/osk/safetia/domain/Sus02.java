package com.osk.safetia.domain;

public class Sus02 {
    private int no;
    private Product product;

    @Override
    public String toString() {
        return "sus02{" +
                "no=" + no +
                ", product=" + product +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
