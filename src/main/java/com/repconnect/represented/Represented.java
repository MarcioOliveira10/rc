package com.repconnect.represented;

import com.repconnect.address.Address;
import com.repconnect.phone.Phone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name= "represented")
@Getter
@Setter
public class Represented implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String webSite;
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "Id")
    private Address address;
    @OneToMany(mappedBy = "represented", cascade = CascadeType.ALL)
    private List<Phone> phones;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;


}
