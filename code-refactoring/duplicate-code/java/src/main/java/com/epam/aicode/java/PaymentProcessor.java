package com.epam.aicode.java;

import java.time.LocalDate;

public class PaymentProcessor {

    private static final String ACTIVE = "active";
    private static final String CREDIT = "credit";
    private static final String HDFC = "HDFC";
    private static final String ICICI = "ICICI";
    private static final String ONLINE = "online";
    private static final String OFFLINE = "offline";

    public Payment processPayment(boolean isOnline) {
        Payment payment = new Payment();
        if (isOnline) {
            payment.setPaymentDate(LocalDate.now());
            payment.setPaymentStatus(ACTIVE);
            payment.setPaymentType(CREDIT);

            payment.setPaymentBank(ICICI);
            payment.setPaymentMode(ONLINE);
        } else {
            payment.setPaymentDate(LocalDate.now());
            payment.setPaymentStatus(ACTIVE);
            payment.setPaymentType(CREDIT);

            payment.setPaymentBank(HDFC);
            payment.setPaymentMode(OFFLINE);
        }
        return payment;
    }
}
