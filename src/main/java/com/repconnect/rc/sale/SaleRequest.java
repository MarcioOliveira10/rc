package com.repconnect.rc.sale;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public record SaleRequest(
        Integer id,
        BigDecimal value,
        Date saleDate,
        String observation,
        Timestamp createdAt,
        Timestamp updatedAt) {
}
