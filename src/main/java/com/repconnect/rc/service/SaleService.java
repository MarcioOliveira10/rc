package com.repconnect.rc.service;

import com.repconnect.rc.domain.Sales;
import com.repconnect.rc.dto.requests.SaleRequest;
import com.repconnect.rc.dto.responses.SaleResponse;
import com.repconnect.rc.mapper.SaleMapper;
import com.repconnect.rc.repositories.SaleRepository;
import com.repconnect.rc.util.SaleUtil;
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
        Sales sale = SaleUtil.createSale(saleRequest);
        var saleSaved = saleRepository.save(sale);

        SaleResponse saleResponse = SaleMapper.toSaleResponse(saleSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);


    }
}
