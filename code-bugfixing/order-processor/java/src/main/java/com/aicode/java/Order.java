package com.aicode.java;

import java.util.Date;
import java.util.List;

class Order {

    String orderId;
    String customerId;
    Date orderDate;
    List<Product> products;

    public Order(String orderId, String customerId, Date orderDate, List<Product> products) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.products = products;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
