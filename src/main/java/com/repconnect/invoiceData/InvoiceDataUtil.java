package com.repconnect.invoiceData;

import com.repconnect.invoice.InvoiceRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InvoiceDataUtil {
    public static Optional<InvoiceData> createInvoiceData(InvoiceRequest invoiceRequest) {
        if(invoiceRequest.invoiceData() == null){
            return Optional.empty();
        }
        InvoiceData invoiceData = new InvoiceData();
        invoiceData.setId(invoiceRequest.id());
        invoiceData.setPdfLink(invoiceRequest.invoiceData().getPdfLink());
        invoiceData.setExcelLink(invoiceRequest.invoiceData().getExcelLink());
        invoiceData.setDate(invoiceRequest.invoiceData().getDate());
        return Optional.of(invoiceData);
    }
}
