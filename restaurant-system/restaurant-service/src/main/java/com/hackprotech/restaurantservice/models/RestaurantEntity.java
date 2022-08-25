package com.hackprotech.restaurantservice.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurantId")
    private Set<FoodItemEntity> foodItems = new HashSet<>();

}
