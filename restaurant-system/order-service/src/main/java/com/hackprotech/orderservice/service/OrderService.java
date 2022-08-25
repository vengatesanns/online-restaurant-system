package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.model.FoodItemsOrder;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.proxy.PaymentProxy;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import com.hackprotech.orderservice.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentProxy paymentProxy;

    public void newOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantId(orderRequest.getRestaurantId());
        orderEntity.setUserId(5555l);

        // Ordered Food Items
        for (FoodItemsRequest foodItemsRequest : orderRequest.getFoodItems()) {
            FoodItemsOrder foodItemsOrder = new FoodItemsOrder();
            foodItemsOrder.setFoodId(foodItemsRequest.getFoodId());
            foodItemsOrder.setQuantity(foodItemsRequest.getQuantity());
            orderEntity.getFoodItemsOrderList().add(foodItemsOrder);
        }
        OrderEntity persistedOrder = orderRepository.save(orderEntity);

        // Initiate the Payment Process
        if (Objects.nonNull(persistedOrder)) {
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setOrderId(persistedOrder.getId());
            paymentRequest.setModeOfPayment(orderRequest.getModeOfPayment());
            ResponseEntity<String> paymentStatus = paymentProxy.processPayment(paymentRequest);
        }
    }

}
