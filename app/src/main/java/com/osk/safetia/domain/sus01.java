package com.osk.safetia.domain;

public class sus01 {
    private int no;
    private product product;

    @Override
    public String toString() {
        return "sus01{" +
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

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }
}
