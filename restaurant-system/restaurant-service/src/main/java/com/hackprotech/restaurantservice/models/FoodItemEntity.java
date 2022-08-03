package com.hackprotech.restaurantservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "food_items")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;
    private String foodName;
    private String foodCategory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_restaurant_id")
    private RestaurantEntity restaurantId;


}
