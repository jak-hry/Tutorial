package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {

        //Given

        //When
        double result1 = calculator.add(0, 2);
        double result2 = calculator.sub(0, 2);
        double result3 = calculator.mul(5, 10);
        double result4 = calculator.div(10, 2);

        //Then
        assertEquals(2, result1);
        assertEquals(-2, result2);
        assertEquals(50, result3);
        assertEquals(5, result4);
    }
}
