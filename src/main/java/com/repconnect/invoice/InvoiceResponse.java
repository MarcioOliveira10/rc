package com.repconnect.invoice;

import com.repconnect.invoiceData.InvoiceData;
import com.repconnect.sale.Sale;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record InvoiceResponse(
        Integer id,
        @NotNull
        String code,
        Date invoiceDate,
        @NotNull
        BigDecimal value,
        String observation,
        Date dueDate,
        InvoiceData invoiceData,
        Sale sales
        ) {

        }

