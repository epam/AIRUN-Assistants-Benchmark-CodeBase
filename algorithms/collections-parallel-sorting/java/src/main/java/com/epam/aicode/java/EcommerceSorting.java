package com.epam.aicode.java;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class EcommerceSorting {

    private EcommerceSorting() {
    }

    public static Map<String, BigDecimal> priceSorting(Map<String, BigDecimal> products, String sortingType) {
        if (sortingType.equalsIgnoreCase("DESC")) {
            return products.entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        } else {
            return products.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        }
    }
}
