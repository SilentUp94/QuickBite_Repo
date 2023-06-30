package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.LoginDto;
import com.sda.QuickBite.entity.User;
import com.sda.QuickBite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {


    @Autowired
    private UserRepository userRepository;

    public Boolean login(LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDto.getEmail());
        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        System.out.println(user.getPassword());
        return loginDto.getPassword().equals(user.getPassword());
    }
}
