package com.example.darazfourthassign.model;

public class Products {
    private String itemName;
    private String Picture;
    private float price;

    public Products( String image,String itemName, float price) {
        itemName = itemName;
        Picture = image;
        price = price;
    }

    public String getDescription() {
        return itemName;
    }

    public void setDescription(String description) {
        itemName = description;
    }

    public String getImage() {
        return Picture;
    }

    public void setImage(String image) {
        Picture = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        price = price;
    }
}

