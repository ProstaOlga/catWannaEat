package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FoodPlanMapper {
//
//    FoodPlanMapper INSTANCE = Mappers.getMapper(FoodPlanMapper.class);
//
//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "meals", target = "meals")
//    @Mapping(source = "cat", qualifiedByName = "mapCatDTO", target = "cat")
////    @Mapping(source = "current", qualifiedByName = "mapCurrent", target = )
//    FoodPlanDTO foodPlanDTOtoFoodPlan(FoodPlan foodPlan);
}
