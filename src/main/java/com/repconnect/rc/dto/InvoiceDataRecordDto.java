package com.repconnect.rc.dto;

import java.util.Date;

public record InvoiceDataRecordDto(String code, String pdfLink, String excelLink, Date date) {
}
