package com.inventory.cat.wanna.eat.dto;

import com.inventory.cat.wanna.eat.models.TimesOfDay;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealDTO {
    Long id;
    FoodDTO food;
    Double weight;
    TimesOfDay timesOfDay;
}
