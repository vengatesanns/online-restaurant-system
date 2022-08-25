package com.hackprotech.orderservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemsRequest {
    private Long foodId;
    private Integer quantity;
}