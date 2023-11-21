package com.repconnect.rc.exceptions;

public record ValidationError(String field, String message) {
}
