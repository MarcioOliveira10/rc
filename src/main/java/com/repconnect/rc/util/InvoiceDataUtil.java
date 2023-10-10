package com.repconnect.rc.util;

import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.dto.requests.InvoiceRequest;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDataUtil {
    public static InvoiceData createInvoiceData(InvoiceRequest invoiceRequest) {
        InvoiceData invoiceData = new InvoiceData();
        invoiceData.setId(invoiceRequest.id());
        invoiceData.setPdfLink(invoiceRequest.invoiceData().getPdfLink());
        invoiceData.setExcelLink(invoiceRequest.invoiceData().getExcelLink());
        invoiceData.setDate(invoiceRequest.invoiceData().getDate());
        return invoiceData;
    }
}
