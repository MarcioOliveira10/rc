package com.repconnect.rc.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public record InvoiceRequestDTO(@NotNull String code, Date invoiceDate,
                                @NotNull BigDecimal value, String observation, Date dueDate) {
}
