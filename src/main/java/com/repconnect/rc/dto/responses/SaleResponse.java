package com.repconnect.rc.dto.responses;

import java.math.BigDecimal;
import java.util.Date;

public record SaleResponse(Integer id,
                           BigDecimal value,
                           Date saleDate,
                           String observation) {
}
