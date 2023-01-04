package com.kodilla.good.patterns.Food2Door;

public class Customer {

    private final String name;
    private final String surName;
    private final String deliveryAddress;
    private final Product product;

    public Customer(final String name, final String surName, final String deliveryAddress, final Product product) {
        this.name = name;
        this.surName = surName;
        this.deliveryAddress = deliveryAddress;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Customer " + name + surName +
                ", deliveryAddress \"" + deliveryAddress + "\"";
    }
}
