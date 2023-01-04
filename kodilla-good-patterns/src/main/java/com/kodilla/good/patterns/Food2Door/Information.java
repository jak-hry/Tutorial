package com.kodilla.good.patterns.Food2Door;

public class Information {

    public void inform(Customer customer, Producer producer) {
        System.out.println(customer.getName() + " " + customer.getSurName() +
                ", product \"" + producer.getProduct() + "\" currently out of stock");
    }
}
