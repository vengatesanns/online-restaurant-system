package com.hackprotech.restaurantservice;

import com.hackprotech.restaurantservice.dao.RestaurantRepository;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantDetails(long restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId);
    }

    public List<RestaurantEntity> getAllRestaurantDetails() {
        return restaurantRepository.findAll();
    }

    public RestaurantEntity saveRestaurantDetails(RestaurantEntity restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }

}
