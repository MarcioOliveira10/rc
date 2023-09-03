package com.repconnect.rc.controllers;

import com.repconnect.rc.dtos.InvoiceRecordDto;
import com.repconnect.rc.models.InvoicesModel;
import com.repconnect.rc.repositories.InvoiceRepositories;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class InvoiceController {
    @Autowired
    private InvoiceRepositories invoiceRepositories;

    @PostMapping("/invoices")
    public ResponseEntity<InvoicesModel> saveInvoice(@RequestBody @Valid InvoiceRecordDto invoiceRecordDto){
        var invoicesModel = new InvoicesModel();
        BeanUtils.copyProperties(invoiceRecordDto, invoicesModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(invoiceRepositories.save(invoicesModel));
    }
    @GetMapping("/invoices")
   public ResponseEntity<List<InvoicesModel>> getAllInvoices(){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceRepositories.findAll());
    }

    @GetMapping("invoices/{id}")
    public ResponseEntity<Object> getOneInvoice(@PathVariable(value = "id")UUID id){
        Optional<InvoicesModel> invoiceOptional = invoiceRepositories.findById(id);
        if(invoiceOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoiceOptional.get());
    }
    @PutMapping("/invoices/{id}")
    public ResponseEntity<Object> updateInvoice(@PathVariable(value = "id") UUID id,
                                                @RequestBody InvoiceRecordDto invoiceRecordDto){
        Optional<InvoicesModel> invoiceO = invoiceRepositories.findById(id);
        if(invoiceO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        var invoiceModel = invoiceO.get();
        BeanUtils.copyProperties(invoiceRecordDto, invoiceModel);
        return ResponseEntity.status(HttpStatus.OK).body(invoiceRepositories.save(invoiceModel));
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable(value = "id") UUID id){
        Optional<InvoicesModel> invoiceO = invoiceRepositories.findById(id);
        if(invoiceO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        invoiceRepositories.delete(invoiceO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Invoice deleted successfully.");
    }




}
