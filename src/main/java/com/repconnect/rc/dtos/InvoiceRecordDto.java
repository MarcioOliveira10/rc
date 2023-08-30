package com.repconnect.rc.dtos;

import java.math.BigDecimal;
import java.util.Date;

public record InvoiceRecordDto(Date invoiceDate, BigDecimal value, String observation, Date dueDate) {
}
