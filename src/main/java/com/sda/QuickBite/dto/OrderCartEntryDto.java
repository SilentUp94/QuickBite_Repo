package com.sda.QuickBite.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderCartEntryDto {
    private String id;
    private String quantity;
    private DishDto dishDto;
}
