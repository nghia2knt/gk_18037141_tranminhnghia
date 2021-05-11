package com.example.myapplication;

import java.io.Serializable;

public class Plant implements Serializable {
    private String name;
    private String detail;
    private String price;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Plant(String name, String detail, String price, int image) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.image = image;
    }

    public Plant() {
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price='" + price + '\'' +
                ", image=" + image +
                '}';
    }
}
