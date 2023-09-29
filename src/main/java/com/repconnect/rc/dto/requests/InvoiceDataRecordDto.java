package com.repconnect.rc.dto.requests;

import java.util.Date;

public record InvoiceDataRecordDto(String code, String pdfLink, String excelLink, Date date) {
}
