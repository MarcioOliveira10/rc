package com.repconnect.rc.controllers;


import com.repconnect.rc.dto.requests.InvoiceRequestDTO;
import com.repconnect.rc.dto.responses.InvoiceResponseDTO;
import com.repconnect.rc.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class InvoiceController {
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    private final InvoiceService invoiceService;

    @PostMapping("/invoices")
    public ResponseEntity<InvoiceResponseDTO> saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequest){
        return invoiceService.addInvoice(invoiceRequest);
    }


    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO findInvoiceById(@PathVariable @Valid Integer id) {
        return invoiceService.findById(id);
    }


    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceResponseDTO>> findAllInvoices() {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAll());
    }




/*

 @PutMapping("/invoices/{code}")
    public ResponseEntity<Object> update(@PathVariable(value = "code") String code,
                                         @RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.updateInvoice());
    }



    @PostMapping("/invoices")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody @Valid InvoiceRequestDTO invoiceRequestDto) {
        return invoiceService.addInvoice(invoiceRequestDto);
    }
------------------------------------------------------------------------------------------------

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
