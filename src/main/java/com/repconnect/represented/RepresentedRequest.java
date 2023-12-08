package com.repconnect.represented;

import com.repconnect.address.Address;
import com.repconnect.phone.Phone;


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
