package com.inventory.cat.wanna.eat.dto;

import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.TimesOfDay;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealDTO {
    private Long id;
    private Long foodId;
    private FoodDTO food;
    private Double weight;
    private TimesOfDay timesOfDay;
}
