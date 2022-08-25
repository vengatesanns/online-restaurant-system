package com.hackprotech.paymentservice.dao;

import com.hackprotech.paymentservice.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
