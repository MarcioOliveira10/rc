package com.repconnect.rc.service;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.dto.InvoiceRequestDTO;
import com.repconnect.rc.dto.request.InvoiceResponseDTO;
import com.repconnect.rc.repositories.InvoiceRepository;
import com.repconnect.rc.util.InvoiceUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private final InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceUtil invoiceUtil;


/*
public List<InvoiceResponseDTO> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
List<InvoiceResponseDTO> invoiceResponseDTOs = invoices.stream()
                .map(invoice -> {
                    InvoiceResponseDTO dto = new InvoiceResponseDTO(
                            invoice.getCode(),
                            invoice.getInvoiceDate(),
                            invoice.getValue(),
                            invoice.getObservation(),
                            invoice.getDueDate(),
                            invoice.getInvoiceData());
                    BeanUtils.copyProperties(invoice, dto);
                    return dto;
                })
                .collect(Collectors.toList());

        return invoiceResponseDTOs;
    }*/


    public List<InvoiceResponseDTO> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream() // Convertendo a lista de Invoice para uma lista de InvoiceResponseDTO
                .map(invoiceUtil::convertToInvoiceResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseEntity<Invoice> addInvoice(InvoiceRequestDTO invoiceRequestDto) {//add ao banco uma nova invoice
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceRequestDto, invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceRepository.save(invoice));
    }


    public InvoiceResponseDTO findById(UUID uuid) { //Busca uma fatura por id
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(uuid);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            return new InvoiceResponseDTO(
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

  public Invoice findById(UUID uuid){
        return invoiceRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice Not Found"));
    }



    @Transactional
    public void deleteInvoice(UUID uuid){
        invoiceRepository.deleteById(uuid);
    }

*/

}
