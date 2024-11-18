package com.epam.aicode.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class EcommerceSorting {

    private EcommerceSorting() {
    }

    public static Map<String, BigDecimal> priceSorting(Map<String, BigDecimal> products, String sortingType) {
        List<Map.Entry<String, BigDecimal>> productList = new ArrayList<>(products.entrySet());
        productList.sort(Map.Entry.comparingByValue());

        if (sortingType.equals("DESC")) {
            Collections.reverse(productList);
        }
        Map<String, BigDecimal> sortedProducts = new LinkedHashMap<>();

        for (Map.Entry<String, BigDecimal> entry : productList) {
            sortedProducts.put(entry.getKey(), entry.getValue());
        }
        return sortedProducts;
    }
}