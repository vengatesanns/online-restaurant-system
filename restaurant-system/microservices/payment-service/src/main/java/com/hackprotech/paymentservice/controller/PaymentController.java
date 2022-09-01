package com.hackprotech.paymentservice.controller;

import com.hackprotech.paymentservice.request.PaymentRequest;
import com.hackprotech.paymentservice.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;

    @PostMapping("/process-payment")
    public ResponseEntity<Boolean> processPayment(@RequestBody PaymentRequest paymentRequest) throws Exception {
        paymentServiceImpl.processPayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }


}
