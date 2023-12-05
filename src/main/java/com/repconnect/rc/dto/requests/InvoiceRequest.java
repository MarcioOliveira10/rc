package com.repconnect.rc.dto.requests;

import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.domain.Sales;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public record InvoiceRequest(Integer id,
                             @NotNull String code,
                             Date invoiceDate,
                             @NotNull BigDecimal value,
                             String observation,
                             Date dueDate,
                             InvoiceData invoiceData,
                             Sales sales) {
}
