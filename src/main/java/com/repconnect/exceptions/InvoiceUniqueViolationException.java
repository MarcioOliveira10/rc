package com.repconnect.exceptions;

public class InvoiceUniqueViolationException extends RuntimeException {
    public InvoiceUniqueViolationException(String message) {
        super(message);
    }
}

