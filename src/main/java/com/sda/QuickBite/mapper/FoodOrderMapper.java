package com.sda.QuickBite.mapper;

import com.sda.QuickBite.dto.FoodOrderDto;
import com.sda.QuickBite.entity.FoodOrder;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class FoodOrderMapper {

    public FoodOrderDto map(FoodOrder foodOrder) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return FoodOrderDto.builder()
                .foodOrderId(foodOrder.getOrderId().toString())
                .date(foodOrder.getOrderDate().format(formatter))
                .restaurantName(foodOrder.getRestaurantName())
                .totalAmount(foodOrder.getTotalAmount().toString())
                .status(foodOrder.getOrderStatus().name())
                .build();
    }
}
