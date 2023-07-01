package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.UserDto;
import com.sda.QuickBite.entity.OrderCart;
import com.sda.QuickBite.entity.User;
import com.sda.QuickBite.mapper.UserMapper;
import com.sda.QuickBite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;
    public void addUser(UserDto userDto){
        User user = userMapper.map(userDto);
        userRepository.save(user);
    }



    public Optional<User> getUserById(String userId) {
        return userRepository.findByUserId(Long.valueOf(userId));
    }

    public Optional<UserDto> getUserDtoById(String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(Long.valueOf(userId));
        if (optionalUser.isEmpty()){
            return Optional.empty();
        }
        User user = optionalUser.get();
        UserDto userDto = userMapper.map(user);
        return Optional.of(userDto);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public Optional<UserDto> getUserDtoByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()){
            return Optional.empty();
        }
        User user = optionalUser.get();
        UserDto userDto = userMapper.map(user);
        return Optional.of(userDto);
    }

    public void updateUserOrderCart(User user) {
        user.setOrderCart(new OrderCart());
        userRepository.save(user);
    }
}
