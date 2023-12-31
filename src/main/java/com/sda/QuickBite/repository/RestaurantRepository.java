package com.sda.QuickBite.repository;

import com.sda.QuickBite.entity.Restaurant;
import com.sda.QuickBite.enums.RestaurantSpecific;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByRestaurantSpecific(RestaurantSpecific restaurantSpecific);

    List<Restaurant> findByUserUserId(String userId);

    Optional<Restaurant> findByMenuDishId(Long dishId);
}
