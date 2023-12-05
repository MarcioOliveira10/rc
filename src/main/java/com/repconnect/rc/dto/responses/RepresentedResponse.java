package com.repconnect.rc.dto.responses;

import com.repconnect.rc.domain.Address;
import com.repconnect.rc.domain.Phone;

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
