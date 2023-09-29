package com.repconnect.rc.service;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.dto.requests.InvoiceRequestDTO;
import com.repconnect.rc.dto.responses.InvoiceResponseDTO;
import com.repconnect.rc.mapper.InvoiceMapper;
import com.repconnect.rc.repositories.InvoiceDataRepository;
import com.repconnect.rc.repositories.InvoiceRepository;
import com.repconnect.rc.util.InvoiceDataUtil;
import com.repconnect.rc.util.InvoiceUtil;
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
    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceDataRepository invoiceDataRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDataRepository = invoiceDataRepository;
    }

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDataRepository invoiceDataRepository;
    @Autowired
    private InvoiceUtil invoiceUtil;


    @Transactional
    public ResponseEntity<InvoiceResponseDTO> addInvoice(InvoiceRequestDTO invoiceRequest) {
        InvoiceData invoiceData = InvoiceDataUtil.createInvoiceData(invoiceRequest);
        Invoice invoice = InvoiceUtil.createInvoice(invoiceRequest, invoiceData);

        InvoiceData invoiceDataSave = invoiceDataRepository.save(invoiceData);
        Invoice invoiceSave = invoiceRepository.save(invoice);

        InvoiceResponseDTO invoiceResponse = InvoiceMapper.toInvoiceResponse(invoiceSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceResponse);
    }


    public List<InvoiceResponseDTO> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream() // Convertendo a lista de Invoice para uma lista de InvoiceResponseDTO
                .map(invoiceUtil::convertToInvoiceResponseDTO)
                .collect(Collectors.toList());
    }

    public InvoiceResponseDTO findById(Integer id) { //Busca uma fatura por id
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            return new InvoiceResponseDTO(
                    invoice.getId(),
                    invoice.getCode(),
                    invoice.getInvoiceDate(),
                    invoice.getValue(),
                    invoice.getObservation(),
                    invoice.getDueDate(),
                    invoice.getInvoiceData());
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
