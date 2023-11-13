package com.repconnect.rc.invoice;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.sale.Sale;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public record InvoiceRequest(
                             Integer id,
                             @NotNull String code,
                             Date invoiceDate,
                             @NotNull BigDecimal value,
                             String observation,
                             Date dueDate,
                             InvoiceData invoiceData,
                             Sale sale) {
}
