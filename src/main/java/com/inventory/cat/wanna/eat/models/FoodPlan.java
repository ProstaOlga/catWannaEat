package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transient
    private boolean active;

    @OneToMany(mappedBy = "foodPlan")
    private List<Meal> meals;

    public FoodPlan() {
        meals = new ArrayList<>();
    }

    @PostLoad
    private void fillActive() {
        active = started != null && finished == null;
    }

    public Long getDailyConsuming(String food) {
        return this.meals.stream()
                .filter(meal -> meal.getFood().getFoodType().equals(food))
                .count();
    }

    public Long getDailyConsuming(Food food) {
        return this.meals.stream()
                .filter(meal -> meal.getFood().equals(food))
                .count();
    }

    public List<Food> getFoods() {
        return this.meals.stream()
                .map(Meal::getFood)
                .collect(Collectors.toList());
    }

    public boolean isFood(String foodName){
        return this.getFoods().stream()
                .anyMatch(food -> foodName.equals(food.getFoodType()));
    }
}
