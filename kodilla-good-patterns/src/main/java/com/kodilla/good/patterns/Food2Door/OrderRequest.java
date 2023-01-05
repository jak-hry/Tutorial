package com.kodilla.good.patterns.Food2Door;

import java.util.Random;

public class OrderRequest {

    public void process() {

        Random random = new Random();
        LoadOrder loadOrder = new LoadOrder();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop("snickers", random.nextInt(100));
        HealthyShop healthyShop = new HealthyShop("apple", random.nextInt(100));
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop("crackers", random.nextInt(100));

        Product product = new Product("potato", random.nextInt(10));
        Customer customer = new Customer("Bryan", "Smith", "długa 13/3", product);

        Producer producer = loadOrder.run(product, extraFoodShop, glutenFreeShop, healthyShop);

        ProductService productService = new ProductService(new TelephoneService(), new Information(), new ProductCheck(), new OrderRepository());
        productService.process(customer, producer, product);

    }
}
