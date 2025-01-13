package com.aicode.java;

class Product {

    String productId;
    String productName;
    String productGroup;
    int quantity;
    double price;

    public Product(String productId, String productName, String productGroup, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productGroup = productGroup;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }
}