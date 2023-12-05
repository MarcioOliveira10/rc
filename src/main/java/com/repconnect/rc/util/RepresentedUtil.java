package com.repconnect.rc.util;

import com.repconnect.rc.domain.Address;
import com.repconnect.rc.domain.Phone;
import com.repconnect.rc.domain.Represented;
import com.repconnect.rc.dto.requests.RepresentedRequest;
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
