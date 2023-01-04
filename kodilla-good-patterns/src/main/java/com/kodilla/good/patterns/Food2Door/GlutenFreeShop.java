package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements Producer {

    private final String product;
    private final int quantity;

    public GlutenFreeShop(final String product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean process(){
        System.out.println("The order has been fulfilled");
        return true;
    }
}