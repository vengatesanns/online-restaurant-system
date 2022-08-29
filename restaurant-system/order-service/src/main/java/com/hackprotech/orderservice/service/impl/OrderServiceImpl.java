package com.hackprotech.orderservice.service.impl;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.exceptions.OrderServiceException;
import com.hackprotech.orderservice.exceptions.PaymentProcessException;
import com.hackprotech.orderservice.model.FoodItemsOrder;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.proxy.PaymentProxy;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import com.hackprotech.orderservice.request.PaymentRequest;
import com.hackprotech.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentProxy paymentProxy;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveNewFoodOrder(OrderRequest orderRequest) {
        try {
            log.info("Processing new Order");
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
            log.info("Order Placed Successfully");

            // Process Payment
            this.processPayment(persistedOrder, orderRequest);
        } catch (Exception ex) {
            log.error("Error while save new food order -> saveNewFoodOrder()", ex);
            throw new OrderServiceException("FAILED while order new food items");
        }
    }

    @Override
    public void processPayment(OrderEntity orderEntity, OrderRequest orderRequest) {
        try {
            // Initiate the Payment Process
            if (Objects.nonNull(orderEntity)) {
                PaymentRequest paymentRequest = new PaymentRequest();
                paymentRequest.setOrderId(orderEntity.getId());
                paymentRequest.setModeOfPayment(orderRequest.getModeOfPayment());
                ResponseEntity<Optional<Boolean>> paymentStatus = paymentProxy.processPayment(paymentRequest);
                if (paymentStatus.getStatusCode() == HttpStatus.OK && paymentStatus.getBody().isPresent()) {
                    log.info("Payment Processed Successfully");
                } else {
                    throw new PaymentProcessException("Failed while processing the Payment");
                }
            }
        } catch (Exception ex) {
            log.error("Error while processing the payment -> processPayment()", ex);
            throw new PaymentProcessException("FAILED while Payment Processing");
        }
    }


}
