package com.hackprotech.restaurantservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RestaurantFoodDTO {

    @Getter
    @Setter
    static class FoodItems {
        private long foodId;
        private String foodName;
        private String foodCategory;
    }

    private long restaurantId;
    private String restaurantName;
    private String location;
    private int phoneNumber;
    private Set<FoodItems> foodItems = new HashSet<>();
}
