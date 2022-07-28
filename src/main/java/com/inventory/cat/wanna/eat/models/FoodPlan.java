package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "food_plan")
@Table(name = "food_plan")
public class FoodPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Cat cat;

    @Column
    private LocalDateTime started;

    @Column
    private LocalDateTime finished;

    @Column
    private boolean current;

    @OneToMany
    private List<Meal> meals;


    public FoodPlan(String name) {
        this.name = name;
    }

    public FoodPlan() {
    }
}
