package com.repconnect.rc.mapper;

import com.repconnect.rc.domain.Phone;
import com.repconnect.rc.domain.Represented;
import com.repconnect.rc.dto.responses.RepresentedResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
