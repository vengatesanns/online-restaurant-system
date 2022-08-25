package com.hackprotech.orderservice.service;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.model.FoodItemsOrder;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
        orderRepository.save(orderEntity);
    }

}
