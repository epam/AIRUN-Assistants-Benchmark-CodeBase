package com.epam.aicode.java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    public void processOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            logger.log(Level.SEVERE, "Order ID is null or empty");
            return;
        }

        logger.log(Level.INFO, "Processing order: {0}", orderId);

        try {
            // Simulate order processing logic
            logger.log(Level.FINE, "Fetching order details for {0}", orderId);
            // Simulating potential exception
            if ("invalid".equals(orderId)) {
                throw new RuntimeException("Order processing error");
            }
            logger.log(Level.INFO, "Order {0} processed successfully", orderId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing order: {0}", orderId);
        }
    }
}
