package com.repconnect.rc.dto.responses;

public record AddressResponse(Integer id,
                              String street,
                              String number,
                              String city,
                              String zip_code,
                              String complement) {
}
