package com.repconnect.rc.invoice;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.sale.Sale;
import com.repconnect.rc.invoiceData.InvoiceDataRepository;
import com.repconnect.rc.sale.SaleRepository;
import com.repconnect.rc.invoiceData.InvoiceDataUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private  InvoiceRepository invoiceRepository;
    @Autowired
    private  InvoiceUtil invoiceUtil;
    @Autowired
    private SaleRepository saleRepository;

    public InvoiceService() {
    }

    @Transactional
    public ResponseEntity<InvoiceResponse> addInvoice(InvoiceRequest invoiceRequest) {
        Optional<InvoiceData> invoiceDataOptional = InvoiceDataUtil.createInvoiceData(invoiceRequest);
        if(invoiceDataOptional.isEmpty()){
            throw new EntityNotFoundException("invoiceData not found");
        }
        InvoiceData invoiceData = invoiceDataOptional.get();
        var salesId = invoiceRequest.sale().getId();
        Sale sales = saleRepository.findById(salesId).orElseThrow(() -> new EntityNotFoundException("Sales not found with id: " + salesId));
        Invoice invoice = InvoiceUtil.createInvoice(invoiceRequest, invoiceData, sales);
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
