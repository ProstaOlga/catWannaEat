package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "addressee")
@Table(name = "addressee")
public class Addressee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    public Addressee(){}

    public Addressee(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
