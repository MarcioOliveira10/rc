package com.repconnect.rc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "invoice_data_ID", referencedColumnName = "Id")
    private InvoiceData invoiceData;


}
