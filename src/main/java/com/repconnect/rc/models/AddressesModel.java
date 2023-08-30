package com.repconnect.rc.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_ADDRESSES")
@Getter
@Setter
public class AddressesModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private String street;
    private Integer number;
    private String city;
    private String zip_code;
    private String complement;

}
