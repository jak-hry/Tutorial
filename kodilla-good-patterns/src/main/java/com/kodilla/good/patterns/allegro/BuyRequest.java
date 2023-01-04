package com.kodilla.good.patterns.allegro;

import java.util.Random;

public class BuyRequest {

    public void buyRequest() {

        Random random = new Random();

        User user = new User("John", "Smith");
        String product1 = "bike";
        double productPrice1 = 14.99;
        int quantity = random.nextInt(2);

        ProductOrderService productOrderService = new ProductOrderService(new ProductOrderRepository(), new MailService(), new InformationService(), new ProductCheck());
        Product product = new Product(product1, productPrice1);

        productOrderService.process(user, product, quantity);

    }
}
