package com.repconnect.rc.represented;

import com.repconnect.rc.address.Address;
import com.repconnect.rc.phone.Phone;

import com.repconnect.rc.address.AddressMapper;
import com.repconnect.rc.phone.PhoneMapper;
import com.repconnect.rc.address.AddressRepository;
import com.repconnect.rc.phone.PhoneRepository;
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
