package com.repconnect.rc.phone;

import com.repconnect.rc.represented.RepresentedRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneMapper {
    public static List<Phone> toPhoneList(RepresentedRequest representedRequest){
        List<Phone> phoneList = representedRequest.phones();
        List<Phone> phones = new ArrayList<>();
        for(Phone objPhone : phoneList){
            Phone phone = new Phone();
            phone.setNumber(objPhone.getNumber());
            phone.setName(objPhone.getName());
            phones.add(phone);
        }
        return phones;
    }
}
