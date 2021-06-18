package com.osk.safetia.domain;

public class nutrition {
    private int no;
    private int salt;//니트륨
    private int carbohydrate;//탄수화물
    private int sugar;//당류
    private int transFat;//트랜스지방
    private int saturatedFat;//포화지방
    private int cholesterol;//콜레스테롤
    private int protein;//단백질

    @Override
    public String toString() {
        return "nutrition{" +
                "no=" + no +
                ", salt=" + salt +
                ", carbohydrate=" + carbohydrate +
                ", sugar=" + sugar +
                ", transFat=" + transFat +
                ", saturatedFat=" + saturatedFat +
                ", cholesterol=" + cholesterol +
                ", protein=" + protein +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getTransFat() {
        return transFat;
    }

    public void setTransFat(int transFat) {
        this.transFat = transFat;
    }

    public int getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(int saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
