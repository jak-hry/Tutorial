package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

class TestingMain {

    public static void main(String[] args) {

        //testing Calculator class
        Calculator calculator = new Calculator();

        int addResult = calculator.add(30, 20);
        int subResult = calculator.substract(35, 10);

        if (addResult == 50 && subResult == 25) {
            System.out.println("Calculator test - okay");
        } else {
            System.out.println("Calculator test - error");
        }
    }
}
