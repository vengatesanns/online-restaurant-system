package com.hackprotech.orderservice.service.impl;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.model.FoodItem;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.dto.FoodItemsDTO;
import com.hackprotech.orderservice.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @BeforeEach
    public void createInstances() {
    }

    @DisplayName("Test the save functionality of new Food Order")
    @Test
    public void saveNewFoodOrder() {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setRestaurantId(1);
//        orderDTO.setModeOfPayment("UPI");
//        List<FoodItemsDTO> foodItems = new ArrayList<>();
//        foodItems.add(new FoodItemsDTO(100l, 2));
//        foodItems.add(new FoodItemsDTO(200l, 5));
//        orderDTO.setFoodItems(foodItems);
//
//        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setRestaurantId(1l);
//        orderEntity.setUserId(5555l);
//        orderEntity.setId(1);
//        List<FoodItem> foodItemList = orderEntity.;
//        foodItemList.add(new FoodItem(1, 100l, 2));
//        foodItemList.add(new FoodItem(2, 200l, 6));
//
//
//        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(orderEntity);
//
//        orderServiceImpl.saveNewFoodOrder(orderDTO);
    }


}
