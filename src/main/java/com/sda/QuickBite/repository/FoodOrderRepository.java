package com.sda.QuickBite.repository;

import com.sda.QuickBite.entity.FoodOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends CrudRepository<FoodOrder,Long> {
    List<FoodOrder> findAllByUserEmail(String email);
}
