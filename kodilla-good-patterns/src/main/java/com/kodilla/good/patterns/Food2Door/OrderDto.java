package com.kodilla.good.patterns.Food2Door;

public class OrderDto {

    private final Customer customer;
    private final Product product;
    private final boolean isInStock;

    public OrderDto(Customer customer, Product product, boolean isInStock) {
        this.customer = customer;
        this.product = product;
        this.isInStock = isInStock;
    }

    public Product getProduct() {
        return product;
    }
}
