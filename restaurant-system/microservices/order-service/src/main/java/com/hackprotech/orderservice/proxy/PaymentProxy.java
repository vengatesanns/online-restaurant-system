package com.hackprotech.orderservice.proxy;

import com.hackprotech.orderservice.dto.PaymentRequest;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "payment-service", path = "/payment")
@LoadBalancerClient(name = "payment-service")
public interface PaymentProxy {

    @PostMapping("/process-payment")
    ResponseEntity<Optional<Boolean>> processPayment(@RequestBody PaymentRequest paymentRequest) throws Exception;
}
