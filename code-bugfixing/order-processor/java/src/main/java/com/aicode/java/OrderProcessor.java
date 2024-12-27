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

        // Calculate the date 30 days prior to the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date thirtyDaysAgo = calendar.getTime();

        // Filter and process orders from the last 30 days
        return orders.stream()
            .filter(order -> !order.getOrderDate().before(thirtyDaysAgo))
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(Product::getProductName, Collectors.summingInt(Product::getQuantity)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No Products");
    }
}