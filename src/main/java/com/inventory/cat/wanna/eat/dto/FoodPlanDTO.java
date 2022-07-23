package com.inventory.cat.wanna.eat.dto;

import java.util.List;

public class FoodPlanDTO {
    long id;
    String name;
    CatDTO cat;
    boolean current;
    List<MealDTO> meals;
}
