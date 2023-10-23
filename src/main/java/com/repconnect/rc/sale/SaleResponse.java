package com.repconnect.rc.sale;

import java.math.BigDecimal;
import java.util.Date;

public record SaleResponse(Integer id,
                           BigDecimal value,
                           Date saleDate,
                           String observation) {
}
