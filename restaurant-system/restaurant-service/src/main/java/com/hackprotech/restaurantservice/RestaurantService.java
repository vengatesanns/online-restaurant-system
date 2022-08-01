package com.hackprotech.restaurantservice;

import com.hackprotech.restaurantservice.dao.RestaurantRepository;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantDetails(long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
        return restaurantEntity;
    }
}
