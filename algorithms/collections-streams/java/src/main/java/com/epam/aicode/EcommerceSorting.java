package com.epam.aicode;

import java.math.BigDecimal;
import java.util.Map;

public final class EcommerceSorting {

    private EcommerceSorting() {
    }

    public static Map<String, BigDecimal> priceSorting(Map<String, BigDecimal> products, String sortingType) {
        Map<String, BigDecimal> sortedMap = new java.util.LinkedHashMap<>();
        java.util.List<java.util.Map.Entry<String, BigDecimal>> entryList = new java.util.ArrayList<>(products.entrySet());
        java.util.List<java.util.Map.Entry<String, BigDecimal>> sortedEntryList = new java.util.ArrayList<>();
        if (sortingType.equals("ASC")) {
            for (int i = 0; i < entryList.size(); i++) {
                java.util.Map.Entry<String, BigDecimal> entry = entryList.get(i);
                if (sortedEntryList.isEmpty()) {
                    sortedEntryList.add(entry);
                } else {
                    int index = 0;
                    for (int j = 0; j < sortedEntryList.size(); j++) {
                        if (entry.getValue().compareTo(sortedEntryList.get(j).getValue()) > 0) {
                            index++;
                        }
                    }
                    sortedEntryList.add(index, entry);
                }
            }
        } else {
            for (int i = 0; i < entryList.size(); i++) {
                java.util.Map.Entry<String, BigDecimal> entry = entryList.get(i);
                if (sortedEntryList.isEmpty()) {
                    sortedEntryList.add(entry);
                } else {
                    int index = 0;
                    for (int j = 0; j < sortedEntryList.size(); j++) {
                        if (entry.getValue().compareTo(sortedEntryList.get(j).getValue()) < 0) {
                            index++;
                        }
                    }
                    sortedEntryList.add(index, entry);
                }
            }
        }
        for (int i = 0; i < sortedEntryList.size(); i++) {
            sortedMap.put(sortedEntryList.get(i).getKey(), sortedEntryList.get(i).getValue());
        }
        return sortedMap;
    }
}
