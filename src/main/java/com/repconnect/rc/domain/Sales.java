package com.repconnect.rc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "TB_SALES")
@Getter
@Setter
public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private BigDecimal value;
    private Date saleDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean proforma;

}
