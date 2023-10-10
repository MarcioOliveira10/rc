package com.repconnect.rc.util;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.domain.Sales;
import com.repconnect.rc.dto.requests.InvoiceRequest;
import com.repconnect.rc.dto.responses.InvoiceResponse;
import com.repconnect.rc.repositories.SaleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceUtil {
    @Autowired
    private static SaleRepository saleRepository;

    public InvoiceResponse convertToInvoiceResponseDTO(Invoice invoice) {
        InvoiceResponse dto = new InvoiceResponse(
                invoice.getId(),
                invoice.getCode(),
                invoice.getInvoiceDate(),
                invoice.getValue(),
                invoice.getObservation(),
                invoice.getDueDate(),
                invoice.getInvoiceData(),
                invoice.getSales());
        BeanUtils.copyProperties(invoice, dto);
        return dto;
    }
    public static Invoice createInvoice(InvoiceRequest invoiceRequest, InvoiceData invoiceData, Sales existingSales) {
        Invoice invoice = new Invoice();
        invoice.setCode(invoiceRequest.code());
        invoice.setInvoiceDate(invoiceRequest.invoiceDate());
        invoice.setValue(invoiceRequest.value());
        invoice.setObservation(invoiceRequest.observation());
        invoice.setDueDate(invoiceRequest.dueDate());
        invoice.setInvoiceData(invoiceData);
        invoice.setSales(existingSales);
        return invoice;
    }

}
