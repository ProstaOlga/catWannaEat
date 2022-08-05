package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.models.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MealMapper {


    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);


     Meal mealDTOtoMeal(MealDTO mealDTO);


     MealDTO mealToMealDTO(Meal meal);






}
