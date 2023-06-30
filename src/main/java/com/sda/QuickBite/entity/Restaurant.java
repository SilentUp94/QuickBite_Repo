package com.sda.QuickBite.entity;

import com.sda.QuickBite.enums.RestaurantSpecific;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String name;
    private String description;
    private String address;
    private String phoneNo;
    private Double rating;

    @Enumerated(value = EnumType.STRING)
    private RestaurantSpecific restaurantSpecific;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] logo;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] backgroundImage;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> menu;


}
