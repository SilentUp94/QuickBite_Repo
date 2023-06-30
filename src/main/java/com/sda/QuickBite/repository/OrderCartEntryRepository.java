package com.sda.QuickBite.repository;

import com.sda.QuickBite.entity.OrderCartEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderCartEntryRepository extends CrudRepository<OrderCartEntry, Long> {
    List<OrderCartEntry> findByOrderCartUserEmail(String name);
}
