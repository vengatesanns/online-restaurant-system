package com.hackprotech.restaurantservice.controller;

import com.hackprotech.restaurantservice.RestaurantService;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    public ResponseEntity<RestaurantEntity> fetchRestaurantDetails(long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantService.getRestaurantDetails(restaurantId);
        return ResponseEntity.status(200).body(restaurantEntity);
    }


}
