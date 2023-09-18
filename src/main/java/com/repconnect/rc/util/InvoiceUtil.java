package com.repconnect.rc.util;

import com.repconnect.rc.domain.Invoice;
import com.repconnect.rc.dto.request.InvoiceResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class InvoiceUtil {

    public InvoiceResponseDTO convertToInvoiceResponseDTO(Invoice invoice) {
        InvoiceResponseDTO dto = new InvoiceResponseDTO(
                invoice.getCode(),
                invoice.getInvoiceDate(),
                invoice.getValue(),
                invoice.getObservation(),
                invoice.getDueDate(),
                invoice.getInvoiceData());
        BeanUtils.copyProperties(invoice, dto);
        return dto;
    }
}
