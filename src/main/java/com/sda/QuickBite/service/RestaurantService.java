package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.RestaurantDto;
import com.sda.QuickBite.entity.Restaurant;
import com.sda.QuickBite.entity.User;
import com.sda.QuickBite.enums.RestaurantSpecific;
import com.sda.QuickBite.mapper.RestaurantMapper;
import com.sda.QuickBite.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(RestaurantDto restaurantDto, MultipartFile restaurantImage, MultipartFile restaurantBackgroundImg, User user) {

        Restaurant restaurant = restaurantMapper.map(restaurantDto, restaurantImage, restaurantBackgroundImg, user);
        restaurantRepository.save(restaurant);
    }

    public Optional<RestaurantDto> getRestaurantDtoById(String restaurantId) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(Long.valueOf(restaurantId));
        if (optionalRestaurant.isEmpty()) {
            return Optional.empty();
        }
        Restaurant restaurant = optionalRestaurant.get();
        RestaurantDto restaurantDto = restaurantMapper.map(restaurant);
        return Optional.of(restaurantDto);
    }

    public Optional<Restaurant> getRestaurantById(String restaurantId) {
        return restaurantRepository.findById(Long.valueOf(restaurantId));
    }


    public List<RestaurantDto> getAllRestaurantDto() {
        Iterable<Restaurant> restaurantIterable = restaurantRepository.findAll();
        return getRestaurantDtoList(restaurantIterable);
    }

    public List<RestaurantDto> getRestaurantsByCategory(String category) {
        Iterable<Restaurant> restaurantIterable = restaurantRepository.findByRestaurantSpecific(RestaurantSpecific.valueOf(category));
        return getRestaurantDtoList(restaurantIterable);
    }

    private List<RestaurantDto> getRestaurantDtoList(Iterable<Restaurant> restaurantIterable) {
        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantIterable) {
            RestaurantDto restaurantDto = restaurantMapper.map(restaurant);
            restaurantDtoList.add(restaurantDto);
        }
        return restaurantDtoList;
    }

    public List<RestaurantDto> getRestaurantDToListByUserId(String userId) {
        List<Restaurant> restaurantList = restaurantRepository.findByUserUserId(userId);
        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getUser().getUserId().equals(userId)) {
                RestaurantDto restaurantDto = restaurantMapper.map(restaurant);
                restaurantDtoList.add(restaurantDto);

            }

        }
        return restaurantDtoList;

    }


}

