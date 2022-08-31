package com.hackprotech.orderservice.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class OrderRequest {

    @NotNull(message = "RestaurantId should not be Null")
    private Long restaurantId;

    @NotNull(message = "Mode of Payment should not be Null")
    private String modeOfPayment;

    @NotNull(message = "Food Items should not be Null")
    @Size(min = 1, message = "Food Items should not be Empty")
    private List<FoodItemsRequest> foodItems;

}



