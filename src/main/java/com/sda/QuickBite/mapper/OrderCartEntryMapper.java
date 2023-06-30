package com.sda.QuickBite.mapper;

import com.sda.QuickBite.dto.OrderCartEntryDto;
import com.sda.QuickBite.entity.OrderCartEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCartEntryMapper {
    @Autowired
    private DishMapper dishMapper;

    public OrderCartEntryDto map(OrderCartEntry orderCartEntry) {
        return OrderCartEntryDto.builder()
                .id(orderCartEntry.getOrderCartEntryId().toString())
                .quantity(orderCartEntry.getQuantity().toString())
                .dishDto(dishMapper.map(orderCartEntry.getDish()))
                .build();
    }
}
