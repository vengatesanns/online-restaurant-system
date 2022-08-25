package com.hackprotech.paymentservice.service;

import com.hackprotech.paymentservice.dao.PaymentRepository;
import com.hackprotech.paymentservice.model.PaymentEntity;
import com.hackprotech.paymentservice.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setTransactionId(UUID.randomUUID().toString());
        paymentEntity.setOrderId(paymentRequest.getOrderId());
        paymentEntity.setModeOfPayment(paymentRequest.getModeOfPayment());
        paymentEntity.setPaidStatus(Boolean.TRUE);
        paymentRepository.save(paymentEntity);
    }

}
