package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.FoodOrderDto;
import com.sda.QuickBite.entity.FoodOrder;
import com.sda.QuickBite.entity.OrderCartEntry;
import com.sda.QuickBite.entity.Restaurant;
import com.sda.QuickBite.entity.User;
import com.sda.QuickBite.enums.OrderStatus;
import com.sda.QuickBite.mapper.FoodOrderMapper;
import com.sda.QuickBite.repository.FoodOrderRepository;
import com.sda.QuickBite.repository.OrderCartEntryRepository;
import com.sda.QuickBite.repository.RestaurantRepository;
import com.sda.QuickBite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodOrderService {

    @Autowired
    private OrderCartEntryRepository orderCartEntryRepository;
    @Autowired
    private OrderCartEntryService orderCartEntryService;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodOrderRepository foodOrderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private FoodOrderMapper foodOrderMapper;

    public void sendFoodOrder(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User not found!");
        }
        List<OrderCartEntry> orderCartEntryList = orderCartEntryRepository .findByOrderCartUserEmail(email);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByMenuDishId(orderCartEntryList.get(0).getDish().getDishId());
        if(optionalRestaurant.isEmpty()){
            throw new RuntimeException("There is some error in the order process!Please contact support");
        }
        User user = optionalUser.get();
        Restaurant restaurant = optionalRestaurant.get();
        double totalAmount = orderCartEntryService.calculateTotalAmount(orderCartEntryList);
        FoodOrder foodOrder = FoodOrder.builder()
                .orderDate(LocalDateTime.now())
                .restaurantName(restaurant.getName())
                .totalAmount(totalAmount)
                .orderStatus(OrderStatus.ACTIVE)
                .user(user)
                .orderCartId(user.getOrderCart().getOrderCartId())
                .build();
        foodOrderRepository.save(foodOrder);
//        userService.updateUserOrderCart(user);
    }

    public List<FoodOrderDto> getAllFoodOrdersDtoByEmail(String email) {
        List<FoodOrder> foodOrderList = foodOrderRepository.findAllByUserEmail(email);
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        for(FoodOrder foodOrder : foodOrderList){
            FoodOrderDto foodOrderDto = foodOrderMapper.map(foodOrder);
            foodOrderDtoList.add(foodOrderDto);
        }
        return foodOrderDtoList;
    }

    public Optional<FoodOrderDto> getFoodOrderDtoById(String foodOrderId) {
        Optional<FoodOrder> optionalFoodOrder = foodOrderRepository.findById(Long.valueOf(foodOrderId));
        if(optionalFoodOrder.isEmpty()){
            return Optional.empty();
        }
        FoodOrder foodOrder = optionalFoodOrder.get();
        FoodOrderDto foodOrderDto = foodOrderMapper.map(foodOrder);

        return Optional.of(foodOrderDto);
    }

    public Optional<FoodOrder> getFoodOrderById(String foodOrderId) {
        return foodOrderRepository.findById(Long.valueOf(foodOrderId));
    }
}
