package com.sda.QuickBite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private String id;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^(?:(?:\\+|00)40|0)(?:(?:2[1-8]|3[1-8]|4[1-8]|5[1-8]|6[1-8]|7[1-9]|8[1-8]|9[1-8])\\d{7}|7[2-8]\\d{8})$"
            , message="Phone number is not valid")
    private String phoneNumber;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotNull(message = "Role is required")
    private String role;


}
