package com.hackprotech.paymentservice.service;

import com.hackprotech.paymentservice.request.PaymentRequest;

import java.util.Optional;

public interface PaymentService {
    Optional<Boolean> processPayment(PaymentRequest paymentRequest) throws Exception;
}
