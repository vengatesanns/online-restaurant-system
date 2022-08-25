package com.hackprotech.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long restaurantId;
    private Long userId;

    @OneToMany(mappedBy = "foodId")
    private List<OrderedFoodItemsEntity> orderedFoodItemsEntityList = new ArrayList<>();

}
