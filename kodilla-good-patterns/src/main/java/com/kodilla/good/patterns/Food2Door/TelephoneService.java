package com.kodilla.good.patterns.Food2Door;

public class TelephoneService {

    public void sendSms(Customer customer) {
        System.out.println("Thanks " + customer.getName() + customer.getSurName() + " for order!");
        System.out.println("the order will be delivered tomorrow to the following address: " + customer.getDeliveryAddress());
    }
}
