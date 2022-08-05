package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodPlanDTO {
    private Long id;
    private String name;
    private boolean active;
    private List<MealDTO> meals;
}
