package com.repconnect.rc.invoice;

public class InvoiceMapper {
    public static Invoice toInvoice(InvoiceRequest invoiceRequest) { // transforma um request em um invoice
        Invoice invoice = new Invoice();
        invoice.setId(invoiceRequest.id());
        invoice.setCode(invoiceRequest.code());
        invoice.setInvoiceDate(invoiceRequest.invoiceDate());
        invoice.setValue(invoiceRequest.value());
        invoice.setObservation(invoiceRequest.observation());
        invoice.setDueDate(invoiceRequest.dueDate());
        invoice.setInvoiceData(invoiceRequest.invoiceData());
        return invoice;
    }

    public static InvoiceResponse toInvoiceResponse(Invoice invoice) { // transforma um invoice em um response
        return new InvoiceResponse(
                invoice.getId(),
                invoice.getCode(),
                invoice.getInvoiceDate(),
                invoice.getValue(),
                invoice.getObservation(),
                invoice.getDueDate(),
                invoice.getInvoiceData(),
                invoice.getSales());
    }
}
