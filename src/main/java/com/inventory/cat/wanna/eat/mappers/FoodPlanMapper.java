package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(uses = MealMapper.class)
public interface FoodPlanMapper {
    FoodPlanMapper INSTANCE = Mappers.getMapper(FoodPlanMapper.class);

    @Mapping(source = "active", qualifiedByName = "setStarted", target = "started")
    FoodPlan foodPlanDTOtoFoodPlan(FoodPlanDTO foodPlanDTO);

    FoodPlanDTO foodPlanToFoodPlanDTO(FoodPlan foodPlan);

    @Named("setStarted")
    default LocalDateTime setStarted(boolean active){
        if (active){
            return LocalDateTime.now();
        }
        else return null;
    }




}
