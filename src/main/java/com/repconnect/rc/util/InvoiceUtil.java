package com.repconnect.rc.util;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.domain.InvoiceData;
import com.repconnect.rc.dto.requests.InvoiceRequestDTO;
import com.repconnect.rc.dto.responses.InvoiceResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class InvoiceUtil {

    public InvoiceResponseDTO convertToInvoiceResponseDTO(Invoice invoice) {
        InvoiceResponseDTO dto = new InvoiceResponseDTO(
                invoice.getId(),
                invoice.getCode(),
                invoice.getInvoiceDate(),
                invoice.getValue(),
                invoice.getObservation(),
                invoice.getDueDate(),
                invoice.getInvoiceData());
        BeanUtils.copyProperties(invoice, dto);
        return dto;
    }
    public static Invoice createInvoice(InvoiceRequestDTO invoiceRequest, InvoiceData invoiceData) {
        Invoice invoice = new Invoice();
        invoice.setCode(invoiceRequest.code());
        invoice.setInvoiceDate(invoiceRequest.invoiceDate());
        invoice.setValue(invoiceRequest.value());
        invoice.setObservation(invoiceRequest.observation());
        invoice.setDueDate(invoiceRequest.dueDate());
        invoice.setInvoiceData(invoiceData);
        return invoice;
    }

}
