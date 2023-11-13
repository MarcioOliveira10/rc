package com.repconnect.rc.sale;


import org.springframework.stereotype.Component;

@Component
public class SaleUtil {
    public static Sale createSale(SaleRequest saleRequest){
        Sale sale = new Sale();
        sale.setValue(saleRequest.value());
        sale.setSaleDate(saleRequest.saleDate());
        sale.setObservation(saleRequest.observation());
        sale.setCreatedAt(saleRequest.createdAt());
        sale.setUpdatedAt(saleRequest.updatedAt());
        return sale;
    }
}
