package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "profile")
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_cat",
            joinColumns = {@JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private List<Cat> cats;

    @OneToMany(mappedBy = "profile")
    private List<FoodBag> foodBags;

    public Profile() {
        cats = new ArrayList<>();
        foodBags = new ArrayList<>();
    }

    @Transactional
    public Long getPresentCountFoodType(Food food) {
        List<Food> currentFoods = getPresentFoodTypes();

        return this.foodBags.stream()
                .filter(fb -> food.getFoodType().equals(fb.getFood().getFoodType()))
                .map(FoodBag::getAmount)
                .reduce(0L, Long::sum);


    }


    public List<Food> getPresentFoodTypes() {
        return this.foodBags.stream()
                .map(FoodBag::getFood).distinct()
                .collect(Collectors.toList());
    }
}
