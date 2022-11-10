package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) + (p - sideC));
    }

}
