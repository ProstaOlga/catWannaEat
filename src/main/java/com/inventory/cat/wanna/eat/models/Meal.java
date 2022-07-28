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
    private Long id;

    @OneToOne
    private Food food;

    @Column
    private Double weight;
    @Column
    private TimesOfDay timesOfDay;

    public Meal(Food food, Double weight, TimesOfDay timesOfDay) {
        this.food = food;
        this.weight = weight;
        this.timesOfDay = timesOfDay;
    }

    public Meal() {
    }
}
