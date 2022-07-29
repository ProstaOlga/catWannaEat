package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "cat")
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private int age;

    @Column
    private int weight;

    @Column
    private String breed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_cat",
            joinColumns = {@JoinColumn(name = "cat_id")},
            inverseJoinColumns = {@JoinColumn(name = "profile_id")})
    private List<Profile> profiles;

    @OneToMany(mappedBy = "cat")
    private List<FoodPlan> foodPlans;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {

    }
}
