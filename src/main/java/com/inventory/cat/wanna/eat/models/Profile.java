package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Profile(){
        cats = new ArrayList<>();
        foodBags = new ArrayList<>();
    }


}
