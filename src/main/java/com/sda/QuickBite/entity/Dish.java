package com.sda.QuickBite.entity;

import com.sda.QuickBite.enums.DishCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dishId;

    private String name;
    private String description;
    private Double price;
    private Integer cookingTime;
    private Double rating;
    @Enumerated(value = EnumType.STRING)
    private DishCategory category;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn
    private Restaurant restaurant;

    @OneToMany(mappedBy = "dish")
    private List<OrderCartEntry> orderCartEntryList;
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

