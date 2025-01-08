package com.epam.aicode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    public List<String> processOrder(Order order) {
        String orderId = order.getOrderId();

        if (orderId == null || orderId.isEmpty()) {
            logger.log(Level.SEVERE, "Order ID is null or empty");
            return null;
        }

        logger.log(Level.INFO, "Processing order: {0}", orderId);
        List<String> productNames = new ArrayList<>();

        try {
            List<Product> products = order.getProducts();

            if (products == null || products.isEmpty()) {
                logger.log(Level.WARNING, "No products found in order: {0}", orderId);
                return null;
            }

            for (Product product : products) {
                productNames.add(product.getProductName());
                logger.log(Level.INFO, "Processed product: {0}", product.getProductId());
            }

            logger.log(Level.INFO, "Order {0} processed successfully", orderId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing order: {0}", orderId);
        }
        return productNames;
    }
}
