package com.sda.QuickBite.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishCategoryDto {
    private String categoryName;
    private List<DishDto> dishDtoList;
}
