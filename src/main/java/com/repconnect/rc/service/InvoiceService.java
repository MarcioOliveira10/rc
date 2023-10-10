package com.repconnect.rc.service;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.domain.Sales;
import com.repconnect.rc.dto.requests.InvoiceRequest;
import com.repconnect.rc.dto.responses.InvoiceResponse;
import com.repconnect.rc.mapper.InvoiceMapper;
import com.repconnect.rc.repositories.InvoiceDataRepository;
import com.repconnect.rc.repositories.InvoiceRepository;
import com.repconnect.rc.repositories.SaleRepository;
import com.repconnect.rc.util.InvoiceDataUtil;
import com.repconnect.rc.util.InvoiceUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceDataRepository invoiceDataRepository, SaleRepository saleRepository,InvoiceUtil invoiceUtil) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDataRepository = invoiceDataRepository;
        this.saleRepository = saleRepository;
        this.invoiceUtil = invoiceUtil;
    }

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDataRepository invoiceDataRepository;
    private final InvoiceUtil invoiceUtil;
    private final SaleRepository saleRepository;





    @Transactional
    public ResponseEntity<InvoiceResponse> addInvoice(InvoiceRequest invoiceRequest) {
        InvoiceData invoiceData = InvoiceDataUtil.createInvoiceData(invoiceRequest);
        var salesId = invoiceRequest.sales().getId();
        Sales sales = saleRepository.findById(salesId).orElseThrow(() -> new EntityNotFoundException("Sales not found with id: " + salesId));
        Invoice invoice = InvoiceUtil.createInvoice(invoiceRequest, invoiceData, sales);
        invoiceDataRepository.save(invoiceData);
        invoiceRepository.save(invoice);
        InvoiceResponse invoiceResponse = InvoiceMapper.toInvoiceResponse(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceResponse);
    }


    public List<InvoiceResponse> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream() // Convertendo a lista de Invoice para uma lista de InvoiceResponseDTO
                .map(invoiceUtil::convertToInvoiceResponseDTO)
                .collect(Collectors.toList());
    }

    public InvoiceResponse findById(Integer id) { //Busca uma fatura por id
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            return new InvoiceResponse(
                    invoice.getId(),
                    invoice.getCode(),
                    invoice.getInvoiceDate(),
                    invoice.getValue(),
                    invoice.getObservation(),
                    invoice.getDueDate(),
                    invoice.getInvoiceData(),
                    invoice.getSales());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice Not Found");
        }

    }




/*

  public InvoiceResponseDTO updateInvoice(InvoiceResponseDTO invoiceResponseDTO, String code){
        Invoice existInvoice = invoiceRepository.findB

    }

  public Invoice findById(UUID uuid){
        return invoiceRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice Not Found"));
    }

    @Transactional
    public void deleteInvoice(UUID uuid){
        invoiceRepository.deleteById(uuid);
    }


      public ResponseEntity<Invoice> addInvoice(InvoiceRequestDTO invoiceRequestDto) {//add ao banco uma nova invoice
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceRequestDto, invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceRepository.save(invoice));
    }

*/

}
