package com.sda.QuickBite.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DishOrderDetailDto {
    private String dishName;
    private String quantity;
    private String costPerDish;
}
