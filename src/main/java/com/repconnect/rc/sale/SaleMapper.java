package com.repconnect.rc.sale;

public class SaleMapper {
    public static SaleResponse toSaleResponse(Sale sale) { // transforma um sale em um response
        return new SaleResponse(
                sale.getId(),
                sale.getValue(),
                sale.getSaleDate(),
                sale.getObservation());
    }
}
