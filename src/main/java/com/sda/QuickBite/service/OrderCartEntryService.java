package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.OrderCartEntryDto;
import com.sda.QuickBite.entity.OrderCartEntry;
import com.sda.QuickBite.mapper.OrderCartEntryMapper;
import com.sda.QuickBite.repository.OrderCartEntryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCartEntryService {
    private final OrderCartEntryRepository orderCartEntryRepository;
    private final OrderCartEntryMapper orderCartEntryMapper;

    public OrderCartEntryService(OrderCartEntryRepository orderCartEntryRepository, OrderCartEntryMapper orderCartEntryMapper) {
        this.orderCartEntryRepository = orderCartEntryRepository;
        this.orderCartEntryMapper = orderCartEntryMapper;
    }

    public List<OrderCartEntryDto> getOrderCartEntryList(String email) {
        List<OrderCartEntry> orderCartEntryList = orderCartEntryRepository.findByOrderCartUserEmail(email);
        List<OrderCartEntryDto> orderCartEntryDtoList = new ArrayList<>();
        for (OrderCartEntry orderCartEntry : orderCartEntryList){
            OrderCartEntryDto orderCartEntryDto = orderCartEntryMapper.map(orderCartEntry);
            orderCartEntryDtoList.add(orderCartEntryDto);
        }
        return orderCartEntryDtoList;
    }
}
