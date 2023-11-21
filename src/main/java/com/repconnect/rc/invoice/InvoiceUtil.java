package com.repconnect.rc.invoice;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.sale.Sale;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class InvoiceUtil {

    public InvoiceResponse convertToInvoiceResponse(Invoice invoice) {
        InvoiceResponse response = new InvoiceResponse(
                invoice.getId(),
                invoice.getCode(),
                invoice.getInvoiceDate(),
                invoice.getValue(),
                invoice.getObservation(),
                invoice.getDueDate(),
                invoice.getInvoiceData(),
                invoice.getSales());
        BeanUtils.copyProperties(invoice, response);
        return response;
    }
    public static Invoice createInvoice(InvoiceRequest invoiceRequest, InvoiceData invoiceData, Sale existingSale) {
        Invoice invoice = new Invoice();
        invoice.setCode(invoiceRequest.code());
        invoice.setInvoiceDate(invoiceRequest.invoiceDate());
        invoice.setValue(invoiceRequest.value());
        invoice.setObservation(invoiceRequest.observation());
        invoice.setDueDate(invoiceRequest.dueDate());
        invoice.setInvoiceData(invoiceData);
        invoice.setSales(existingSale);
        return invoice;
    }

}
