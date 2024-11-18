package com.epam.aicode.java;

public class DiscountAction {

    public Discount calculateDiscount(double price, String userType, boolean isHoliday) {
        double discountRate = 0;
        if (userType.equals("STUDENT")) {
            discountRate = price * 0.1;
        } else if (userType.equals("SENIOR")) {
            discountRate = price * 0.15;
        } else if (userType.equals("EMPLOYEE")) {
            discountRate = price * 0.2;
        }
        if (isHoliday) {
            discountRate += price * 0.05;
        }

        Discount discount = new Discount();
        discount.setRate(discountRate);
        discount.setUserType(userType);
        discount.setHoliday(isHoliday);

        return discount;
    }
}
