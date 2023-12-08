package com.repconnect.represented;

import com.repconnect.address.Address;
import com.repconnect.phone.Phone;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RepresentedUtil {

    public static Represented createRepresented(RepresentedRequest representedRequest, List<Phone> phones, Address address){
        Represented represented = new Represented();
        represented.setName(representedRequest.name());
        represented.setEmail(representedRequest.email());
        represented.setWebSite(representedRequest.webSite());
        represented.setAddress(representedRequest.address());
        represented.setCreatedAt(representedRequest.createdAt());
        represented.setUpdatedAt(representedRequest.updatedAt());
        represented.setPhones(phones);
        represented.setAddress(address);
        return represented;

    }
}
