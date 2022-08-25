package com.hackprotech.orderservice.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    private long restaurantId;
    private List<FoodItemsRequest> foodItems;

}



