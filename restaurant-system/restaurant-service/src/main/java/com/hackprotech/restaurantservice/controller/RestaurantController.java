package com.hackprotech.restaurantservice.controller;

import com.hackprotech.restaurantservice.RestaurantService;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/fetch/{restaurantId}")
    public ResponseEntity<RestaurantEntity> fetchRestaurantDetails(@PathVariable long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantService.getRestaurantDetails(restaurantId);
        return ResponseEntity.status(200).body(restaurantEntity);
    }

    @GetMapping("/fetch-all")
    public List<RestaurantEntity> fetchAllRestaurantDetails() {
        List<RestaurantEntity> restaurantEntity = restaurantService.getAllRestaurantDetails();
        return restaurantEntity;
    }

    @PostMapping("/save")
    public ResponseEntity<RestaurantEntity> saveRestaurantDetails(@RequestBody RestaurantEntity restaurantRequest) {
        RestaurantEntity restaurantEntity = restaurantService.saveRestaurantDetails(restaurantRequest);
        return ResponseEntity.status(200).body(restaurantEntity);
    }


}
