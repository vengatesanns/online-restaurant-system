package com.hackprotech.orderservice.service.impl;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.dto.OrderDTO;
import com.hackprotech.orderservice.dto.PaymentRequest;
import com.hackprotech.orderservice.exceptions.OrderServiceException;
import com.hackprotech.orderservice.exceptions.PaymentProcessException;
import com.hackprotech.orderservice.model.FoodItem;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.proxy.PaymentProxy;
import com.hackprotech.orderservice.request.OrderRequest;
import com.hackprotech.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentProxy paymentProxy;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderDTO saveNewFoodOrder(OrderRequest orderRequest) {
        OrderDTO orderDTO;
        try {
            log.info("Processing new Order");
            // Order Details
            OrderEntity orderEntity = modelMapper.map(orderRequest, OrderEntity.class);
            orderEntity.setUserId(5555l);

            // Ordered Food Items
            List<FoodItem> foodItemList = orderRequest.getFoodItems().stream().map(foodItem -> modelMapper.map(foodItem, FoodItem.class)).collect(Collectors.toList());
            orderEntity.setFoodItems(foodItemList);

            OrderEntity processedOrder = orderRepository.save(orderEntity);

            if (Objects.isNull(processedOrder)) {
                throw new OrderServiceException("Error while saving the Order Details");
            }

            log.info("Order Placed Successfully");
            orderDTO = modelMapper.map(processedOrder, OrderDTO.class);
            orderDTO.setOrderId(processedOrder.getId());


            // Process Payment
//            this.processPayment(persistedOrder, orderRequest);
        } catch (Exception ex) {
            log.error("Error while save new food order -> saveNewFoodOrder()", ex);
            throw new OrderServiceException("FAILED while order new food items");
        }
        return orderDTO;
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
