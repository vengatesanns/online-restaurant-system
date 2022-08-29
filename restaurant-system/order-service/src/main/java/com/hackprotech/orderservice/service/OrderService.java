package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.OrderRequest;

public interface OrderService {

    void saveNewFoodOrder(OrderRequest orderRequest);

    void processPayment(OrderEntity orderEntity, OrderRequest orderRequest);

}
