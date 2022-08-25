package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.model.OrderedFoodItemsEntity;
import com.hackprotech.orderservice.request.FoodItems;
import com.hackprotech.orderservice.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void newOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantId(orderRequest.getRestaurantId());
        orderEntity.setUserId(5555l);
        List<OrderedFoodItemsEntity> orderedFoodItemsEntityList = new ArrayList<>();
        for (FoodItems foodItems : orderRequest.getFoodItems()) {
            OrderedFoodItemsEntity orderedFoodItemsEntity = new OrderedFoodItemsEntity();
            orderedFoodItemsEntity.setFoodId(foodItems.getFoodId());
            orderedFoodItemsEntityList.add(orderedFoodItemsEntity);
        }
        orderEntity.setOrderedFoodItemsEntityList(orderedFoodItemsEntityList);
    }

}
