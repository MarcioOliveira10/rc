package com.repconnect.rc.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="TB_INVOICES")
public class InvoicesModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private Date invoiceDate;
    private BigDecimal value;
    @Lob @Basic(fetch = FetchType.LAZY)
    private String observation;
    private Date dueDate;
    //private Integer invoiceData_id;

}
