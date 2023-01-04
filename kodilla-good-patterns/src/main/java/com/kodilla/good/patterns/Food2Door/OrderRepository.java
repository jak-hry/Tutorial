package com.kodilla.good.patterns.Food2Door;

import java.util.Random;

public class OrderRepository {

    public boolean productOrder(Customer customer, Product product) {
        return new Random().nextBoolean();
    }
}
