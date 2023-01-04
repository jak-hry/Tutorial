package com.kodilla.good.patterns.allegro;

public class ProductCheck {

    public boolean productCheck(User user, Product product, int quantity) {

        if (quantity != 0) {
            return true;
        } else {
            System.out.println("Product \"" + product.getProductName() + "\" was sold out");
            return false;
        }
    }
}
