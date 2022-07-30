package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "food_plan")
@Table(name = "food_plan")
public class FoodPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", updatable = false)
    private Cat cat;

    @Column
    private LocalDateTime started;

    @Column
    private LocalDateTime finished;

    @Column
    private boolean current;

    @OneToMany(mappedBy = "foodPlan")
    private List<Meal> meals;



    public FoodPlan() {
        meals = new ArrayList<>();
    }
}
