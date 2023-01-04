package com.kodilla.good.patterns.Food2Door;

public class ProductCheck {

    public boolean productCheck(Customer customer, Product product) {

        if (product.getQuantity() != 0) {
            return true;
        } else {
            System.out.println("Product \"" + product.getProductName() + "\" was sold out");
            return false;
        }
    }
}
