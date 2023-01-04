package com.kodilla.good.patterns.Food2Door;

public class Application {

    public static void main(String[] args) {

        OrderRequest orderRequest = new OrderRequest();
        ProductService productService = new ProductService(new TelephoneService(), new Information(), new ProductCheck(), new OrderRepository());
        productService.process(orderRequest);
    }
}
