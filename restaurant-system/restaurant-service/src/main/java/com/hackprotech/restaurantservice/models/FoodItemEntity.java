package com.hackprotech.restaurantservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "food_items")
@Getter
@Setter
public class FoodItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;
    private String foodName;
    private String foodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_restaurant_id")
    private RestaurantEntity restaurantId;


}
