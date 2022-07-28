package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodPlanMapper {
    FoodPlanMapper INSTANCE = Mappers.getMapper(FoodPlanMapper.class);


    FoodPlan foodPlanDTOtoFoodPlan(FoodPlanDTO foodPlanDTO);

    FoodPlanDTO foodPlanToFoodPlanDTO(FoodPlan foodPlan);
}
