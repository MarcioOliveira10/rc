package com.repconnect.rc.controllers;

import com.repconnect.rc.sale.SaleRequest;
import com.repconnect.rc.sale.SaleResponse;
import com.repconnect.rc.sale.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SalesController {
    public final SaleService saleService;

    public SalesController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sales")
    public ResponseEntity<SaleResponse> saveSale(@RequestBody SaleRequest saleRequest){
    return saleService.addSale(saleRequest);

    }
}
