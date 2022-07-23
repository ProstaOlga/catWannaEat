package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "food_bag")
@Table(name = "food_bag")
public class FoodBag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long foodBagId;

    @ManyToOne
    private Cat cat;

    @OneToOne
    private Food foodType;

    @Column
    private long amount;

    @Column
    private LocalDateTime packingDate;

    public FoodBag(Food foodType) {
        this.foodType = foodType;
        this.packingDate = LocalDateTime.now();
    }

    public FoodBag() {

    }
}
