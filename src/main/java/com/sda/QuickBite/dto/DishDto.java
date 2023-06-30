package com.sda.QuickBite.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DishDto {

    private String id;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be no more than 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 200, message = "Description must be no more than 200 characters")
    private String description;

    @NotBlank(message = "Price is required")
    private String price;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Cooking time is required")
    private String cookingTime;

    private String image;

}
