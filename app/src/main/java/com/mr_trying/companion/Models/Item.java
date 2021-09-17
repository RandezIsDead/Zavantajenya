package com.mr_trying.companion.Models;

public class Item {

    private String imageUrl;
    private String name;
    private String cost;
    private String isShop;

    public Item(String imageUrl, String name, String cost) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cost = cost;
    }

    public Item() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getIsShop() {
        return isShop;
    }

    public void setIsShop(String isShop) {
        this.isShop = isShop;
    }
}
