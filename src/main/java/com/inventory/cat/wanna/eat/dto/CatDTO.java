package com.inventory.cat.wanna.eat.dto;

import com.inventory.cat.wanna.eat.models.FoodBag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CatDTO {
    Long id;
    String name;
    int age;
    int weight;
    String breed;
}
