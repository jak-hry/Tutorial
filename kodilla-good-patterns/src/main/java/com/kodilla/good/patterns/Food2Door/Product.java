package com.kodilla.good.patterns.Food2Door;

public class Product {

    private final String productName;
    private final int quantity;

    public Product(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product " + productName + ", quantity " + quantity;
    }
}
