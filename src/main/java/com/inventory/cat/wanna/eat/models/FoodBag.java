package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity(name = "food_bag")
@Table(name = "food_bag")
public class FoodBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", updatable = false)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", updatable = false)
    private Profile profile;

    @Column
    private Long amount;

    @Column
    private LocalDate packingDate;


    public FoodBag(Food food) {
        this.food = food;
        this.packingDate = LocalDate.now();
    }

    public FoodBag() {

    }
}
