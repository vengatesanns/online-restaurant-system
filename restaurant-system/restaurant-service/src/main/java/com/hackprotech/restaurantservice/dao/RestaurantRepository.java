package com.hackprotech.restaurantservice.dao;

import com.hackprotech.restaurantservice.models.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    RestaurantEntity findByRestaurantId(long restaurantId);
}
