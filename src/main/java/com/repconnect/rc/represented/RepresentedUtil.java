package com.repconnect.rc.represented;

import com.repconnect.rc.address.Address;
import com.repconnect.rc.phone.Phone;
import com.repconnect.rc.represented.Represented;
import com.repconnect.rc.represented.RepresentedRequest;
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
