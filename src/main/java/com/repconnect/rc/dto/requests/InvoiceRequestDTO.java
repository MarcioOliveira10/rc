package com.repconnect.rc.dto.requests;

import com.repconnect.rc.domain.InvoiceData;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


public record InvoiceRequestDTO(Integer id,@NotNull String code, Date invoiceDate,
                                @NotNull BigDecimal value, String observation, Date dueDate, InvoiceData invoiceData) {
}
