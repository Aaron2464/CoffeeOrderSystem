package com.aaron.coffeeordersystem.Object;

public class CoffeePostion {
    private int postion;
    private CoffeeItem mCoffeeItem;

    public CoffeePostion() {

    }

    public CoffeePostion(int postion, CoffeeItem coffeeItem) {
        this.postion = postion;
        mCoffeeItem = coffeeItem;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public CoffeeItem getCoffeeItem() {
        return mCoffeeItem;
    }

    public void setCoffeeItem(CoffeeItem coffeeItem) {
        mCoffeeItem = coffeeItem;
    }
}
