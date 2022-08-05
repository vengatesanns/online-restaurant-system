package com.hackprotech.restaurantservice.controller;

import com.hackprotech.restaurantservice.RestaurantService;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("*")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/fetch/{restaurantId}")
    public ResponseEntity<RestaurantEntity> fetchRestaurantDetails(@PathVariable long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantService.getRestaurantDetails(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(restaurantEntity);
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<RestaurantEntity>> fetchAllRestaurantDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getAllRestaurantDetails());
    }

    @PostMapping("/save")
    public ResponseEntity<RestaurantEntity> saveRestaurantDetails(@Valid @RequestBody RestaurantEntity restaurantRequest) {
        RestaurantEntity restaurantEntity = restaurantService.saveRestaurantDetails(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantEntity);
    }

}
