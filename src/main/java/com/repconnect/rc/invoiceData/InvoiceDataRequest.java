package com.repconnect.rc.invoiceData;

import java.util.Date;

public record InvoiceDataRequest(String code, String pdfLink, String excelLink, Date date) {
}
