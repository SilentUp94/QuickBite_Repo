package com.sda.QuickBite.service;

import com.sda.QuickBite.dto.OrderCartEntryDto;
import com.sda.QuickBite.dto.TotalAmountDto;
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

    public TotalAmountDto getOrderTotalAmount(String email) {
        List<OrderCartEntry> orderCartEntryList = orderCartEntryRepository.findByOrderCartUserEmail(email);
        double totalAmount = calculateTotalAmount(orderCartEntryList);
        return TotalAmountDto.builder().totalAmount(String.valueOf(totalAmount)).build();
    }

    public double calculateTotalAmount(List<OrderCartEntry> orderCartEntryList) {
        double totalAmount = 0;
        for (OrderCartEntry orderCartEntry : orderCartEntryList){
            totalAmount = totalAmount + orderCartEntry.getQuantity()*orderCartEntry.getDish().getPrice();
        }
        return totalAmount;
    }

    public List<OrderCartEntry> getOrderCartEntryListByOrderCartId(Long orderCartId) {
        return orderCartEntryRepository.findAllByOrderCartOrderCartId(orderCartId);
    }
}
