package com.hackprotech.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "food_items_order")
@Getter
@Setter
public class FoodItemsOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long foodId;
    private Integer quantity;
}
