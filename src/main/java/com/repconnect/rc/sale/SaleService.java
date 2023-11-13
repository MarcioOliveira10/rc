package com.repconnect.rc.sale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public ResponseEntity<SaleResponse> addSale(SaleRequest saleRequest) {
        Sale sale = SaleUtil.createSale(saleRequest);
        var saleSaved = saleRepository.save(sale);

        SaleResponse saleResponse = SaleMapper.toSaleResponse(saleSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);


    }
}
