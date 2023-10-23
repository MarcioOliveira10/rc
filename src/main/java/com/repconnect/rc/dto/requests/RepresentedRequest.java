package com.repconnect.rc.dto.requests;

import com.repconnect.rc.domain.Address;
import com.repconnect.rc.domain.Phone;


import java.sql.Timestamp;
import java.util.List;

public record RepresentedRequest(String name,
                                 String webSite,
                                 String email,
                                 Timestamp createdAt,
                                 Timestamp updatedAt,
                                 List<Phone> phones,
                                 Address address) {
}
