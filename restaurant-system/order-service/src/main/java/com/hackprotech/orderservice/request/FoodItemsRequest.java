package com.hackprotech.orderservice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemsRequest {
    private Long foodId;
    private Integer quantity;
}