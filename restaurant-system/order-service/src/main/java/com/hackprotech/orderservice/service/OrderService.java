package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.dto.OrderDTO;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.OrderRequest;

public interface OrderService {

    OrderDTO saveNewFoodOrder(OrderRequest orderRequest);

    void processPayment(OrderEntity orderEntity, OrderRequest orderRequest);

}
