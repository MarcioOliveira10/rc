package com.repconnect.represented;

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
