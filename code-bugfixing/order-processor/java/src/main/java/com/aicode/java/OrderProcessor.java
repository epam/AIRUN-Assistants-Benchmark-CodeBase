package com.aicode.java;

import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {

    /**
     * Calculates the most popular product based on the total quantity sold from orders
     * placed in the last 30 days.
     *
     * <p>This method processes a list of orders and identifies the product with the highest
     * cumulative quantity sold in the last 30 days. If no products are found within this
     * timeframe, "No Products" is returned.</p>
     *
     * @return the name of the most popular product as determined by the highest total quantity sold
     *         in the last 30 days, or "No Products" if there are no qualifying products.
     */
    public String calculateMostPopularProduct(List<Order> orders) {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.HOUR, -30);
        Date thirtyDaysAgo = calendar.getTime();

        return orders.stream()
            .filter(order -> order.getOrderDate().before(thirtyDaysAgo))
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(Product::getProductName, Collectors.summingInt(Product::getQuantity)))
            .entrySet().stream()
            .max(Map.Entry.comparingByKey())
            .map(Map.Entry::getKey)
            .orElse("No Products");
    }
}