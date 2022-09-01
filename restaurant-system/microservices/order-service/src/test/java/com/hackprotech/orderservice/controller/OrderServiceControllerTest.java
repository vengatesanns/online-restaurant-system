package com.hackprotech.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackprotech.orderservice.dto.OrderDTO;
import com.hackprotech.orderservice.model.FoodItem;
import com.hackprotech.orderservice.model.OrderEntity;
import com.hackprotech.orderservice.request.FoodItemsRequest;
import com.hackprotech.orderservice.request.OrderRequest;
import com.hackprotech.orderservice.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(value = OrderController.class)
public class OrderServiceControllerTest {

    @InjectMocks
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;

    @Test
    @DisplayName("Test the new order processing endpoint")
    public void testNewOrderProcessingEndpoint() throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantId(100l);
        orderEntity.setId(12);
        List<FoodItem> foodItemList = orderEntity.getFoodItems();
        foodItemList.add(new FoodItem(1, 100l, 2));
        foodItemList.add(new FoodItem(2, 200l, 6));
        OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setRestaurantId(100l);
        orderRequest.setModeOfPayment("UPI");
        List<FoodItemsRequest> foodItems = new ArrayList<>();
        foodItems.add(new FoodItemsRequest(100l, 2));
        foodItems.add(new FoodItemsRequest(200l, 5));
        orderRequest.setFoodItems(foodItems);

        OrderDTO mockedOrderDTO = new OrderDTO(100, 12);
        when(orderService.saveNewFoodOrder(any(OrderRequest.class))).thenReturn(mockedOrderDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/new-order").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orderRequest));
        MvcResult mockMvcResponse = mockMvc.perform(requestBuilder).andReturn();
        String response = mockMvcResponse.getResponse().getContentAsString();

        OrderDTO endpointResponse = objectMapper.readValue(response, OrderDTO.class);

        assertEquals(endpointResponse.getOrderId(), orderEntity.getId());
        assertEquals(endpointResponse.getRestaurantId(), orderEntity.getRestaurantId());
        assertEquals(mockMvcResponse.getResponse().getStatus(), 201);
    }


    @Test
    @DisplayName("Test the Bad Request on the new order process endpoint")
    public void testBadRequestOnNewOrderProcessingEndpoint() throws Exception {
        OrderRequest orderRequest = new OrderRequest();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/new-order").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orderRequest));
        MvcResult mockMvcResponse = mockMvc.perform(requestBuilder).andReturn();
        String response = mockMvcResponse.getResponse().getContentAsString();
        assertEquals(response, "");
        assertEquals(mockMvcResponse.getResponse().getStatus(), 400);
    }
}
