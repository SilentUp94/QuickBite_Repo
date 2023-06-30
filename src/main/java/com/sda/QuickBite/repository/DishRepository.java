package com.sda.QuickBite.repository;

import com.sda.QuickBite.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {

    @Query("SELECT MAX(id) FROM Dish")
    Long findMaxId();
}
