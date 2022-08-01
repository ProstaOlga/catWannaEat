package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "meal")
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", updatable = false)
    private Food food;

    @Transient
    private Long foodId;

    @Column
    private Double weight;
    @Column
    @Enumerated(EnumType.STRING)
    private TimesOfDay timesOfDay;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_plan_id", updatable = false)
    private FoodPlan foodPlan;

    public Meal() {
    }

}
