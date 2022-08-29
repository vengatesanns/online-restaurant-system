package com.hackprotech.paymentservice.service.impl;

import com.hackprotech.paymentservice.dao.PaymentRepository;
import com.hackprotech.paymentservice.model.PaymentEntity;
import com.hackprotech.paymentservice.request.PaymentRequest;
import com.hackprotech.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Boolean> processPayment(PaymentRequest paymentRequest) throws Exception {
        Optional<Boolean> paymentStatus;
        try {
            log.info("Payment Processing");
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setTransactionId(UUID.randomUUID().toString());
            paymentEntity.setOrderId(paymentRequest.getOrderId());
            paymentEntity.setModeOfPayment(paymentRequest.getModeOfPayment());
            paymentEntity.setPaidStatus(Boolean.TRUE);
            PaymentEntity processedPayment = paymentRepository.save(paymentEntity);
            paymentStatus = Objects.nonNull(processedPayment) ? Optional.of(Boolean.TRUE) : Optional.of(Boolean.FALSE);
            log.info("Payment Processed Successfully");
        } catch (Exception ex) {
            log.error("Error while processing the payment -> processPayment()", ex);
            throw new Exception("Error while processing the payment -> processPayment() - ".concat(ex.getMessage()));
        }
        return paymentStatus;
    }

}
