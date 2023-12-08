package com.repconnect.represented;

import com.repconnect.address.Address;
import com.repconnect.address.AddressMapper;
import com.repconnect.address.AddressRepository;
import com.repconnect.phone.Phone;
import com.repconnect.phone.PhoneRepository;

import com.repconnect.phone.PhoneMapper;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RepresentedService {

    private final RepresentedRepository representedRepository;
    private final AddressRepository addressRepository;
    private final PhoneRepository phoneRepository;

    public RepresentedService(RepresentedRepository representedRepository, AddressRepository addressRepository, PhoneRepository phoneRepository) {
        this.representedRepository = representedRepository;
        this.addressRepository = addressRepository;
        this.phoneRepository = phoneRepository;
    }


    @Transactional
    public ResponseEntity<RepresentedResponse> addRepresented(RepresentedRequest representedRequest){
        Address address = AddressMapper.toAddress(representedRequest);
        List<Phone> phones = PhoneMapper.toPhoneList(representedRequest);
        Represented represented = RepresentedUtil.createRepresented(representedRequest, phones, address );
        Represented representedSaved = representedRepository.save(represented);
        RepresentedResponse representedResponse = RepresentedMapper.representedToRepresentedResponse(representedSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(representedResponse);
    }
}
