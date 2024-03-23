package com.hackprotech.paymentservice.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_detail")
@Getter
@Setter
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String transactionId;
    private Long orderId;
    private String modeOfPayment;
    private Boolean paidStatus;
}
