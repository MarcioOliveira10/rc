package com.repconnect.rc.sale;

import com.repconnect.rc.sale.Sales;
import com.repconnect.rc.sale.SaleResponse;

public class SaleMapper {
    public static SaleResponse toSaleResponse(Sales sale) { // transforma um sale em um response
        return new SaleResponse(
                sale.getId(),
                sale.getValue(),
                sale.getSaleDate(),
                sale.getObservation());
    }
}
