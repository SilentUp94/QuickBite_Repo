package com.sda.QuickBite.dto;


import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;



@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class RestaurantDto {

    private String id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^(?:(?:\\+|00)40|0)(?:(?:2[1-8]|3[1-8]|4[1-8]|5[1-8]|6[1-8]|7[1-9]|8[1-8]|9[1-8])\\d{7}|7[2-8]\\d{8})$"
            , message="Phone number is not valid")
    private String phoneNo;

    @NotEmpty(message = "Restaurant specific information is required")
    private String restaurantSpecific;

    private String logo;

    private String backgroundImage;
}
