package com.repconnect.invoice;

import com.repconnect.invoiceData.InvoiceData;
import com.repconnect.sale.Sale;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public record InvoiceRequest(
                             Integer id,
                             @NotBlank(message = "The CODE cannot be empty")
                             String code,
                             Date invoiceDate,
                             @NotNull BigDecimal value,
                             String observation,
                             @FutureOrPresent(message = "the DATE must be in the future.")
                             Date dueDate,
                             InvoiceData invoiceData,
                             Sale sale) {
}
