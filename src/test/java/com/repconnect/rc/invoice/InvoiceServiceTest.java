package com.repconnect.rc.invoice;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.sale.SaleRepository;
import com.repconnect.rc.sale.Sale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InvoiceServiceTest {
    @InjectMocks
    InvoiceService service;
    @Mock
    SaleRepository saleRepository;
    @Mock
    InvoiceRepository invoiceRepository;





    @Test
    @DisplayName("Must save invoice successfully")
    void addInvoiceWithSuccess() throws ParseException {
        // arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("23-04-2023");
        BigDecimal value = new BigDecimal("1230.00");
        InvoiceData invoiceData = new InvoiceData();
        Sale sales = new Sale();

        InvoiceRequest invoiceRequest = new InvoiceRequest(
                123,
                "FS23-1234",
                date,
                value,
                "A factura está a data errada",
                date,
                invoiceData,
                sales);

        Mockito.when(saleRepository.findById(invoiceRequest.sale().getId())).thenReturn(Optional.of(sales));
        Mockito.when(invoiceRepository.save(Mockito.any(Invoice.class))).thenReturn(new Invoice());
        // action
        service.addInvoice(invoiceRequest);
        // assertions
        Mockito.verify(saleRepository).findById(invoiceRequest.sale().getId());
        Mockito.verify(invoiceRepository).save(Mockito.any(Invoice.class));

        }

}
//setup
// Arrange


//teste
// Action


//validaçoes
// Assertions