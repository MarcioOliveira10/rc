package com.repconnect.rc.address;

public record AddressResponse(Integer id,
                              String street,
                              String number,
                              String city,
                              String zip_code,
                              String complement) {
}
