package com.sda.QuickBite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OrderCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCartId;


    @OneToOne(mappedBy = "orderCart")
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "orderCart")
    private List<OrderCartEntry> orderCartEntryList;


}
