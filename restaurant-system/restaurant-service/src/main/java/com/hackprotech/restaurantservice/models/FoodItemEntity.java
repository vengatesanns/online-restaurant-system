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

}
