package com.sda.QuickBite.utils;

import com.sda.QuickBite.dto.UserDto;
import com.sda.QuickBite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@Component
public class Util {

    @Autowired
    private UserService userService;
    public static final String BASE64_PREFIX = "data:image/png; base64, ";

    public byte[] convertToBytes(MultipartFile multipartFile){
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }
    }
    public void saveImage(MultipartFile dishImage,String name, Long id) {
        try{
            Path path = Paths.get("src/main/resources/static/img/"+ name);
            Files.createDirectories(path);
            String imageName = dishImage.getOriginalFilename();

            Files.copy(dishImage.getInputStream(),path.resolve( name + "_" + id.toString() + ".png"));
        }catch (Exception e){
            throw new RuntimeException("Error upload image!");
        }
    }
    public String displayAuthenticatedUserFullName (Authentication authentication) {
        String email = authentication.getName();
        Optional<UserDto> optionalUserDto = userService.getUserDtoByEmail(email);
        if (optionalUserDto.isEmpty()) {
            return "Not Authenticated";
        }
        UserDto userDto = optionalUserDto.get();
        return userDto.getFirstName() + " " + userDto.getLastName();
    }
}
