package com.repconnect.rc.controllers;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.dto.InvoiceRequestDTO;
import com.repconnect.rc.dto.request.InvoiceResponseDTO;
import com.repconnect.rc.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping
public class InvoiceController {
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    private final InvoiceService invoiceService;
    @PostMapping("/invoices")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody @Valid InvoiceRequestDTO invoiceRequestDto){
        return invoiceService.addInvoice(invoiceRequestDto);
    }

    @GetMapping("/invoices/{uuid}")
    public InvoiceResponseDTO findInvoiceById(@PathVariable @Valid UUID uuid) {
        return invoiceService.findById(uuid);
    }


    @GetMapping("/invoices")
   public ResponseEntity<List<InvoiceResponseDTO>> findAllInvoices(){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAll());
    }

    @PutMapping("/invoices/{uuid}")
    public ResponseEntity<Object> update(@PathVariable(value = "uuid") UUID uuid,
                                         @RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.updateInvoice());
    }
/*
    @GetMapping("invoices/{id}")
    public ResponseEntity<Object> getOneInvoice(@PathVariable(value = "id")UUID id){
        Optional<Invoice> invoiceOptional = invoiceRepositories.findById(id);
        if(invoiceOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoiceOptional.get());
    }
    @PutMapping("/invoices/{id}")
    public ResponseEntity<Object> updateInvoice(@PathVariable(value = "id") UUID id,
                                                @RequestBody InvoiceRecordDto invoiceRecordDto){
        Optional<Invoice> invoiceO = invoiceRepositories.findById(id);
        if(invoiceO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        var invoiceModel = invoiceO.get();
        BeanUtils.copyProperties(invoiceRecordDto, invoiceModel);
        return ResponseEntity.status(HttpStatus.OK).body(invoiceRepositories.save(invoiceModel));
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable(value = "id") UUID id){
        Optional<Invoice> invoiceO = invoiceRepositories.findById(id);
        if(invoiceO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        invoiceRepositories.delete(invoiceO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Invoice deleted successfully.");
    }

*/


}
