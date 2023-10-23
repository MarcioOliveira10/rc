package com.repconnect.rc.represented;

import com.repconnect.rc.address.Address;
import com.repconnect.rc.phone.Phone;


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
