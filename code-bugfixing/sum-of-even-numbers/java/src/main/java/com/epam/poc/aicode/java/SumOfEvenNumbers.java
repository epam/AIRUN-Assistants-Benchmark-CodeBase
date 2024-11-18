package com.epam.poc.aicode.java;

public class SumOfEvenNumbers {

    public static int sumOfEvenNumbers(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
