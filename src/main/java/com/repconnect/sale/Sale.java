package com.repconnect.sale;

import com.repconnect.represented.Represented;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name= "sales")
@Getter
@Setter
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal value;
    private Date saleDate;
    private String observation;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "represented_id", referencedColumnName = "Id")
    private Represented represented;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;


}
