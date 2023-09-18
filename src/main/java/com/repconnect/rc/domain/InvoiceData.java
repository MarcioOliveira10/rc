package com.repconnect.rc.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name="TB_INVOICE_DATA")
@Getter
public class InvoiceData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String pdfLink;
    private String excelLink;
    private Date date;
}
