package com.aaron.coffeeordersystem.Object;

public class CoffeeItem {
    private String image;
    private String name;
    private int price;

    public CoffeeItem() {
    }

    public CoffeeItem(String image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
