package com.inventory.cat.wanna.eat.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode

@Entity(name = "food")
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String foodType;

    @OneToOne
    private Profile profile;

    @OneToMany(mappedBy = "food")
    private List<FoodBag> foodBags;


    public Food() {
        foodBags = new ArrayList<>();
    }
}
