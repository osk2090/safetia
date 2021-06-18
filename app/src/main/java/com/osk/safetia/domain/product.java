package com.osk.safetia.domain;

public class product {
    private int no;//상품번호
    private String model;//상품명
    private int price;//가격
    private String company;//제조사
    private String photo;//사진

    @Override
    public String toString() {
        return "product{" +
                "no=" + no +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
