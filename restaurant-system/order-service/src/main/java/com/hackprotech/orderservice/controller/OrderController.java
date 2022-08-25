package com.hackprotech.orderservice.controller;

import com.hackprotech.orderservice.request.OrderRequest;
import com.hackprotech.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/new-order")
    public ResponseEntity<String> newOrder(@RequestBody OrderRequest orderRequest) {
        orderService.newOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order Created Successfully!!!");
    }

}
