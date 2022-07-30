package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.Meal;
import com.inventory.cat.wanna.eat.models.TimesOfDay;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MealMapper {


    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);


    abstract Meal mealDTOtoMeal(MealDTO mealDTO);


    abstract MealDTO mealToMealDTO(Meal meal);






}
