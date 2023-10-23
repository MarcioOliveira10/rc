package com.repconnect.rc.represented;

import com.repconnect.rc.represented.Represented;
import com.repconnect.rc.represented.RepresentedResponse;
import org.springframework.stereotype.Component;

@Component
public class RepresentedMapper {
    public static RepresentedResponse representedToRepresentedResponse(Represented represented){
        return new RepresentedResponse(
                represented.getId(),
                represented.getName(),
                represented.getEmail(),
                represented.getWebSite(),
                represented.getPhones(),
                represented.getAddress(),
                represented.getCreatedAt(),
                represented.getUpdatedAt()
        );
    }
}
