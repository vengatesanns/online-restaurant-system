package com.hackprotech.restaurantservice;

import com.hackprotech.restaurantservice.dao.RestaurantRepository;
import com.hackprotech.restaurantservice.dto.RestaurantFoodDTO;
import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantDetails(long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
        return restaurantEntity;
    }

    public List<RestaurantEntity> getAllRestaurantDetails() {
        List<RestaurantEntity> restaurantEntity = restaurantRepository.findAll();
        RestaurantFoodDTO restaurantFoodDTO = new RestaurantFoodDTO();
        for (RestaurantEntity restaurant : restaurantEntity) {
            restaurantFoodDTO.setRestaurantId(restaurant.getRestaurantId());
            restaurantFoodDTO.setRestaurantName(restaurant.getRestaurantName());
            restaurantFoodDTO.setLocation(restaurant.getLocation());
            restaurantFoodDTO.setPhoneNumber(restaurant.getPhoneNumber());
        }
        return restaurantEntity;
    }

    public RestaurantEntity saveRestaurantDetails(RestaurantEntity restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }

}
