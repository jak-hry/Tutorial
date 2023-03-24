package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testPizzaWithHamAndChampignonGetCost() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamPizzaOrder(theOrder);
        theOrder = new ChampignonPizzaOrder(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18), theCost);
    }

    @Test
    void testPizzaWithHamAndChampignonGetDescription() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamPizzaOrder(theOrder);
        theOrder = new ChampignonPizzaOrder(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with: tomato sauce + cheese + ham + champignon", description);
    }

    @Test
    void testPizzaWithCheeseAndDoughGetCost() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheesePizzaOrder(theOrder);
        theOrder = new DoughPizzaOrder(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(22), theCost);
    }

    @Test
    void testPizzaWithCheeseAndDoughGetDescription() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheesePizzaOrder(theOrder);
        theOrder = new DoughPizzaOrder(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with: tomato sauce + cheese + cheese + dough", description);
    }
}
