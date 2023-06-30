package com.sda.QuickBite.mapper;

import com.sda.QuickBite.dto.UserDto;
import com.sda.QuickBite.entity.OrderCart;
import com.sda.QuickBite.entity.User;
import com.sda.QuickBite.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User map(UserDto userDto){
        String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .phoneNumber(userDto.getPhoneNumber())
                .password(encodedPassword)
                .role(Role.valueOf(userDto.getRole()))
                .orderCart(new OrderCart())
                .build();
    }

    public UserDto map(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .build();



    }
}
