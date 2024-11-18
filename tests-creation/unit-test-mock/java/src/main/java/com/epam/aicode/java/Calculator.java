package com.epam.aicode.java;

public class Calculator {

    private CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double add(double a, double b) {
        return calculatorService.add(a, b);
    }

    public double subtract(double a, double b) {
        return calculatorService.subtract(a, b);
    }

    public double multiply(double a, double b) {
        return calculatorService.multiply(a, b);
    }
}
