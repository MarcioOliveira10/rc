package com.repconnect.rc.invoiceData;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.invoice.InvoiceRequest;
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
