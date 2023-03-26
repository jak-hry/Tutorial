package com.kodilla.patterns2.math.testing.aop.calculator;

import com.kodilla.patterns2.aop.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalculatorTestSuite {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        //Given
        //When
        double result = calculator.add(5, 10);
        //Then
        LOGGER.info("testing add method");
        assertEquals(15, result);
    }

    @Test
    void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 5);
        //Then
        LOGGER.info("testing sub method");
        assertEquals(5, result);
    }

    @Test
    void testMul() {
        //Given
        //When
        double result = calculator.mul(2, 5);
        //Then
        LOGGER.info("testing mul method");
        assertEquals(10, result);
    }

    @Test
    void testDiv() {
        //Given
        //When
        double result = calculator.div(20, 5);
        //Then
        LOGGER.info("testing div method");
        assertEquals(4, result);
    }

    @Test
    public void testFactorial() {

        //Given
        //When
        BigDecimal result = calculator.factorial(new BigDecimal("1000"));
        //Then
        LOGGER.info("testing factorial method");
        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}
