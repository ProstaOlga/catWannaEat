package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity(name = "food_bag")
@Table(name = "food_bag")
public class FoodBag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Food foodType;

    @Column
    private Long amount;

    @Column
    private LocalDate packingDate;

    public FoodBag(Food foodType) {
        this.foodType = foodType;
        this.packingDate = LocalDate.now();
    }

    public FoodBag() {

    }
}
