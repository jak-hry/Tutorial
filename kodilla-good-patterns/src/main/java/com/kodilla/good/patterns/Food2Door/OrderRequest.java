package com.kodilla.good.patterns.Food2Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OrderRequest {

    public void process() {

        Random random = new Random();
        LoadOrder loadOrder = new LoadOrder();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop("snickers", random.nextInt(100));
        HealthyShop healthyShop = new HealthyShop("apple", random.nextInt(100));
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop("crackers", random.nextInt(100));

        Product product = new Product("apple", random.nextInt(10));
        Customer customer = new Customer("Bryan", "Smith", "długa 13/3", product);

        List<Producer> producerList = new ArrayList<>();
        producerList.add(extraFoodShop);
        producerList.add(healthyShop);
        producerList.add(glutenFreeShop);

        Optional<Producer> producer = loadOrder.run(product, producerList);

        if (producer.isPresent()) {
            ProductService productService = new ProductService(new TelephoneService(), new Information(), new ProductCheck(), new OrderRepository());
            productService.process(customer, producer.get(), product);
        } else {
            System.out.println("not for sale");
        }
    }
}
