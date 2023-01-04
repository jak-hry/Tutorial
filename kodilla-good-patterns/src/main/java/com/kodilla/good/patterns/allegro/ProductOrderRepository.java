package com.kodilla.good.patterns.allegro;

import java.util.Random;

public class ProductOrderRepository {

    public boolean productOrder(User user, Product product) {
        return new Random().nextBoolean();
    }
}
