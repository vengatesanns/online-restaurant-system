package com.hackprotech.orderservice.service.impl;

import com.hackprotech.orderservice.dao.OrderRepository;
import com.hackprotech.orderservice.dto.OrderDTO;
import com.hackprotech.orderservice.exceptions.OrderServiceException;
import com.hackprotech.orderservice.model.FoodItem;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Spy
    private ModelMapper modelMapper;

    OrderRequest orderRequest;

    @BeforeEach
    public void createOrderRequest() {
        orderRequest = new OrderRequest();
        orderRequest.setRestaurantId(1l);
        orderRequest.setModeOfPayment("UPI");
        List<FoodItemsRequest> foodItems = new ArrayList<>();
        foodItems.add(new FoodItemsRequest(100l, 2));
        foodItems.add(new FoodItemsRequest(200l, 5));
        orderRequest.setFoodItems(foodItems);
    }

    @Test
    @DisplayName("Test the save functionality of new Food Order")
    public void saveNewFoodOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantId(1l);
        orderEntity.setId(1);
        List<FoodItem> foodItemList = orderEntity.getFoodItems();
        foodItemList.add(new FoodItem(1, 100l, 2));
        foodItemList.add(new FoodItem(2, 200l, 6));

        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(orderEntity);

        OrderDTO orderDTO = orderServiceImpl.saveNewFoodOrder(orderRequest);

        Assertions.assertEquals(orderEntity.getId(), orderDTO.getOrderId());
        Assertions.assertEquals(orderEntity.getRestaurantId(), orderDTO.getRestaurantId());
    }

    @Test
    @DisplayName("OrderService Exception will be thrown due to Save Operation")
    public void saveNewFoodOrder_with_orderServiceException() {
        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenThrow(IllegalArgumentException.class);
        OrderServiceException orderServiceException = assertThrows(OrderServiceException.class, () -> orderServiceImpl.saveNewFoodOrder(orderRequest));
        assertEquals(orderServiceException.getMessage(), "FAILED while order new food items");
    }

    @Test
    @DisplayName("NullPointerException will be thrown due to orderRequestNull")
    public void saveNewFoodOrder_with_NullPointerException() {
        orderRequest = null;
        OrderServiceException orderServiceException = assertThrows(OrderServiceException.class, () -> orderServiceImpl.saveNewFoodOrder(orderRequest));
        assertEquals(orderServiceException.getMessage(), "FAILED while order new food items");
    }

    @Test
    @DisplayName("OrderRepository Save should be called only once")
    public void verify_orderRepo_save_called_only_once() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantId(1l);
        orderEntity.setId(1);
        List<FoodItem> foodItemList = orderEntity.getFoodItems();
        foodItemList.add(new FoodItem(1, 100l, 2));
        foodItemList.add(new FoodItem(2, 200l, 6));

        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(orderEntity);

        OrderDTO orderDTO = orderServiceImpl.saveNewFoodOrder(orderRequest);

        Assertions.assertEquals(orderEntity.getId(), orderDTO.getOrderId());
        Assertions.assertEquals(orderEntity.getRestaurantId(), orderDTO.getRestaurantId());
        Mockito.verify(orderRepository, Mockito.times(1)).save(Mockito.any(OrderEntity.class));
    }


}
