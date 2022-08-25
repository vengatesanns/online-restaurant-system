package com.hackprotech.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_food_items")
@Getter
@Setter
public class OrderedFoodItemsEntity {

    @Id
    private long foodId;
}
