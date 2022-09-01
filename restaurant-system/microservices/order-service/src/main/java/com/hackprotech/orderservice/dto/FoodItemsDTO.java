package com.hackprotech.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemsDTO {
    private Long foodId;
    private Integer quantity;
}