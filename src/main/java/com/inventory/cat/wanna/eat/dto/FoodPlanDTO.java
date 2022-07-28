package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodPlanDTO {
    Long id;
    String name;
    boolean current;
    List<MealDTO> meals;
}
