package com.repconnect.address;

import com.repconnect.represented.RepresentedRequest;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public static Address toAddress(RepresentedRequest representedRequest){
        Address address = new Address();
        address.setStreet(representedRequest.address().getStreet());
        address.setNumber(representedRequest.address().getNumber());
        address.setCity(representedRequest.address().getCity());
        address.setZip_code(representedRequest.address().getZip_code());
        address.setComplement(representedRequest.address().getComplement());
        address.setCreatedAt(representedRequest.createdAt());
        address.setUpdatedAt(representedRequest.updatedAt());
        return address;
    }

    public static AddressResponse toAddressResponse(Address address){
        AddressResponse response = new AddressResponse(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getZip_code(),
                address.getComplement());
        return response;
    }



}
