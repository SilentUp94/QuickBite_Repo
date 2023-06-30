package com.sda.QuickBite.entity;

import com.sda.QuickBite.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    private String address;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Restaurant> restaurantList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private OrderCart orderCart;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<FoodOrder> orders;



}
