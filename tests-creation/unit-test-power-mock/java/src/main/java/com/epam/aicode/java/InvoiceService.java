package com.epam.aicode.java;

public class InvoiceService {

    public Invoice buildInvoice(String id, double price) {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setPrice(price);
        invoice.setDateTime(DataUtils.getIsoDateTime());
        return invoice;
    }
}
