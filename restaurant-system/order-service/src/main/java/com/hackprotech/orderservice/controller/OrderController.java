package com.hackprotech.orderservice.controller;

import com.hackprotech.orderservice.dto.OrderDTO;
import com.hackprotech.orderservice.exceptions.OrderServiceException;
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
    private OrderService orderServiceImpl;

    @PostMapping("/new-order")
    public ResponseEntity<OrderDTO> newOrder(@RequestBody OrderRequest orderRequest) throws OrderServiceException {
        OrderDTO orderDTO = orderServiceImpl.saveNewFoodOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }

}
