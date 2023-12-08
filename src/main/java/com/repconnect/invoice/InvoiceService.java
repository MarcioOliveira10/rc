package com.repconnect.invoice;

import com.repconnect.exceptions.InvoiceUniqueViolationException;
import com.repconnect.invoiceData.InvoiceData;
import com.repconnect.invoiceData.InvoiceDataUtil;
import com.repconnect.sale.Sale;
import com.repconnect.sale.SaleRepository;
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
        InvoiceData invoiceData = createInvoiceData(invoiceRequest);
        Sale sales = getSaleById(invoiceRequest.sale().getId());
        checkIfInvoiceCodeExists(invoiceRequest.code());

        Invoice invoice = InvoiceUtil.createInvoice(invoiceRequest, invoiceData, sales);
        invoiceRepository.save(invoice);


        InvoiceResponse invoiceResponse = InvoiceMapper.toInvoiceResponse(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceResponse);
    }
    private InvoiceData createInvoiceData(InvoiceRequest invoiceRequest){
        return InvoiceDataUtil.createInvoiceData(invoiceRequest).orElseThrow(() -> new EntityNotFoundException("Invoice data not found"));
    }

    private Sale getSaleById(Integer saleId){
        return saleRepository.findById(saleId).orElseThrow(()-> new EntityNotFoundException("Sales not found with id: "+ saleId));
    }
    private void checkIfInvoiceCodeExists(String invoiceCode){
        if(invoiceRepository.findByCode(invoiceCode).isPresent()){
            throw new InvoiceUniqueViolationException(String.format(" Invoice %s already registered ", invoiceCode));
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------

    public List<InvoiceResponse> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream() // Convertendo a lista de Invoice para uma lista de InvoiceResponseDTO
                .map(invoiceUtil::convertToInvoiceResponse)
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
