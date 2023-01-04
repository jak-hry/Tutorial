package com.kodilla.good.patterns.allegro;

public class InformationService {

    public void inform(User user, Product product) {
        System.out.println(user + ", product \"" + product.getProductName() + "\" currently out of stock");
    }

}
