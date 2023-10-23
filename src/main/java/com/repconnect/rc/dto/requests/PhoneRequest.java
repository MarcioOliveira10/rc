package com.repconnect.rc.dto.requests;

import java.sql.Timestamp;

public record PhoneRequest(Integer id,
                           String number,
                           String name,
                           Timestamp createdAt,
                           Timestamp updatedAt) {
}
