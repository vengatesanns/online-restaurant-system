package com.hackprotech.paymentservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private Long orderId;
    private String modeOfPayment;
}
