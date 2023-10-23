package com.repconnect.rc.represented;

import com.repconnect.rc.address.Address;
import com.repconnect.rc.phone.Phone;

import java.sql.Timestamp;
import java.util.List;

public record RepresentedResponse(Integer id,
                                  String name,
                                  String webSite,
                                  String email,
                                  List<Phone> phones,
                                  Address address,
                                  Timestamp createdAt,
                                  Timestamp updatedAt) {
}
