package com.kodilla.good.patterns.Food2Door;

public class LoadOrder {

    public Producer run(Product product, Producer extraFoodShop, Producer glutenFreeShop, Producer healthyShop) {

        if (product.getProductName().equals(extraFoodShop.getProduct())) {
            return new ExtraFoodShop(extraFoodShop.getProduct(), extraFoodShop.getQuantity());
        } else if (product.getProductName().equals(glutenFreeShop.getProduct())) {
            return new GlutenFreeShop(glutenFreeShop.getProduct(), glutenFreeShop.getQuantity());
        } else if (product.getProductName().equals(healthyShop.getProduct())) {
            return new HealthyShop(healthyShop.getProduct(), healthyShop.getQuantity());
        } else {
            System.out.println("not for sale");
           return extraFoodShop;
        }

    }
}
