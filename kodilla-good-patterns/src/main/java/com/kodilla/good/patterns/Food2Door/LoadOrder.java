package com.kodilla.good.patterns.Food2Door;

import java.util.List;
import java.util.Optional;

public class LoadOrder {

    public Optional<Producer> run(Product product, List<Producer> producerList) {

        return producerList.stream()
                .filter(producer -> product.getProductName().equals(producer.getProduct()))
                .findAny();
    }
}
