package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "cat")
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private int age;

    @Column
    private int weight;

    @Column
    private String breed;


    public Cat(String name) {
        this.name = name;
    }

    public Cat() {

    }
}
