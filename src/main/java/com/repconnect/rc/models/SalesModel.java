package com.repconnect.rc.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class SalesModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private BigDecimal value;
    private Date saleDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
