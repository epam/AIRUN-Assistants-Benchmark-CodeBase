package com.epam.poc.aicode.java;

import java.util.List;

public class FindLargestEvenNumber {

    public static int findLargestEvenNumber(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .sorted((n1, n2) -> n2 - n1)
            .findFirst()
            .get();
    }
}
