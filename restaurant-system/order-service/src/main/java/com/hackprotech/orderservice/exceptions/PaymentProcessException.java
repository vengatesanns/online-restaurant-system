package com.hackprotech.orderservice.exceptions;

public class PaymentProcessException extends RuntimeException {

    public PaymentProcessException(String message) {
        super(message);
    }
}
