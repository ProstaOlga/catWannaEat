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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Cat cat;

    @OneToOne
    private Food food;

    @ManyToOne
    private FoodPlan foodPlan;
    
    @Column
    private long weight;
    @Column
    private TimeOfDay timesOfDay;

    public Meal(Food food, long weight, TimeOfDay timesOfDay) {
        this.food = food;
        this.weight = weight;
        this.timesOfDay = timesOfDay;
    }

    public Meal() {
    }
}
