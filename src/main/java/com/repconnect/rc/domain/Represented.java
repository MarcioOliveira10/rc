package com.repconnect.rc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_REPRESENTED")
@Getter
@Setter
public class Represented implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private String document;
    private String webSite;
    private String email;

}
