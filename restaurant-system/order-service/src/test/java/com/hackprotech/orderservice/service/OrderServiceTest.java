package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    public void insertNewOrder() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setRestaurantId(1);
        orderRequest.setModeOfPayment("UPI");
        List<FoodItemsRequest> foodItems = new ArrayList<>();
        foodItems.add(new FoodItemsRequest(100l, 2));
        foodItems.add(new FoodItemsRequest(200l, 5));
        orderRequest.setFoodItems(foodItems);
        orderRequest.setFoodItems(orderRequest.getFoodItems());

        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(new OrderEntity());

        orderService.newOrder(orderRequest);
    }


}
