package com.repconnect.rc.util;


import com.repconnect.rc.domain.Sales;
import com.repconnect.rc.dto.requests.SaleRequest;
import org.springframework.stereotype.Component;

@Component
public class SaleUtil {
    public static Sales createSale(SaleRequest saleRequest){
        Sales sale = new Sales();
        sale.setValue(saleRequest.value());
        sale.setSaleDate(saleRequest.saleDate());
        sale.setObservation(saleRequest.observation());
        sale.setCreatedAt(saleRequest.createdAt());
        sale.setUpdatedAt(saleRequest.updatedAt());
        return sale;
    }
}
