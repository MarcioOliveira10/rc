package com.repconnect.rc.mapper;

import com.repconnect.rc.domain.Sales;
import com.repconnect.rc.dto.responses.SaleResponse;

public class SaleMapper {
    public static SaleResponse toSaleResponse(Sales sale) { // transforma um sale em um response
        return new SaleResponse(
                sale.getId(),
                sale.getValue(),
                sale.getSaleDate(),
                sale.getObservation());
    }
}
