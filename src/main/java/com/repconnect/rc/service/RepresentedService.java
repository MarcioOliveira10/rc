package com.repconnect.rc.service;

import com.repconnect.rc.domain.Address;
import com.repconnect.rc.domain.Phone;
import com.repconnect.rc.domain.Represented;

import com.repconnect.rc.dto.requests.RepresentedRequest;
import com.repconnect.rc.dto.responses.RepresentedResponse;
import com.repconnect.rc.mapper.AddressMapper;
import com.repconnect.rc.mapper.PhoneMapper;
import com.repconnect.rc.mapper.RepresentedMapper;
import com.repconnect.rc.repositories.AddressRepository;
import com.repconnect.rc.repositories.PhoneRepository;
import com.repconnect.rc.repositories.RepresentedRepository;
import com.repconnect.rc.util.RepresentedUtil;
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
