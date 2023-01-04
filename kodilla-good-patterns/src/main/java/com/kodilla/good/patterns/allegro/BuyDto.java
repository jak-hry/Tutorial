package com.kodilla.good.patterns.allegro;

public class BuyDto {

    private final User user;
    private final boolean isInStock;
    private final Product product;

    public BuyDto(final User user, final Product product, final boolean isInStock) {
        this.user = user;
        this.product = product;
        this.isInStock = isInStock;
    }

    public User getUser() {
        return user;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public Product getProduct() {
        return product;
    }
}
