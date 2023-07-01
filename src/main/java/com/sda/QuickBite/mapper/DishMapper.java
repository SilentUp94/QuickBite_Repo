package com.sda.QuickBite.mapper;

import com.sda.QuickBite.dto.DishDto;
import com.sda.QuickBite.dto.DishOrderDetailDto;
import com.sda.QuickBite.entity.Dish;
import com.sda.QuickBite.entity.OrderCartEntry;
import com.sda.QuickBite.entity.Restaurant;
import com.sda.QuickBite.enums.DishCategory;
import com.sda.QuickBite.utils.Util;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static com.sda.QuickBite.utils.Util.BASE64_PREFIX;

@Component
public class DishMapper {
    @Autowired
    private Util util;
    public Dish map(DishDto dishDto, MultipartFile dishImage, Restaurant restaurant) {
        return Dish.builder()
                .name(dishDto.getName())
                .description(dishDto.getDescription())
                .price(Double.valueOf(dishDto.getPrice()))
                .cookingTime(Integer.valueOf(dishDto.getCookingTime()))
                .category(DishCategory.valueOf(dishDto.getCategory()))
                .image(util.convertToBytes(dishImage))
                .restaurant(restaurant)
                .build();
    }
    public DishDto map(Dish dish){
        return DishDto.builder()
                .id(dish.getDishId().toString())
                .name(dish.getName())
                .description(dish.getDescription())
                .cookingTime(dish.getCookingTime().toString())
                .category(dish.getCategory().name())
                .price(String.format("%.2f", dish.getPrice()))
                .image(BASE64_PREFIX + Base64.encodeBase64String(dish.getImage()))
                .build();
    }

    public DishOrderDetailDto map(OrderCartEntry orderCartEntry) {

        Double costPerDish = orderCartEntry.getDish().getPrice() * orderCartEntry.getQuantity();
        return DishOrderDetailDto.builder()
                .dishName(orderCartEntry.getDish().getName())
                .quantity(orderCartEntry.getQuantity().toString())
                .costPerDish(costPerDish.toString())
                .build();
    }
}
