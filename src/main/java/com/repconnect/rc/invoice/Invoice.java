package com.repconnect.rc.invoice;

import com.repconnect.rc.invoiceData.InvoiceData;
import com.repconnect.rc.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="invoices")
public class Invoice implements Serializable {
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private Date invoiceDate;
    private BigDecimal value;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String observation;
    private Date dueDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "invoice_data_ID", referencedColumnName = "Id")
    private InvoiceData invoiceData;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="sale_ID", referencedColumnName = "Id" )
    private Sale sales;


}
