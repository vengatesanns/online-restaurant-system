package com.hackprotech.orderservice.proxy;

import com.hackprotech.orderservice.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Payment", url = "http://localhost:9200/payment")
public interface PaymentProxy {

    @PostMapping("process-payment")
    ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest);
}
