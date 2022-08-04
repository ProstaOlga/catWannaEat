package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = MealMapper.class)
public interface FoodPlanMapper {
    FoodPlanMapper INSTANCE = Mappers.getMapper(FoodPlanMapper.class);

    FoodPlan foodPlanDTOtoFoodPlan(FoodPlanDTO foodPlanDTO);

//    @Mapping(source = "foodPlan", qualifiedByName = "foodPlanDTOmeals", target = "meals")
//    FoodPlanDTO foodPlanToFoodPlanDTO(FoodPlan foodPlan);

    FoodPlanDTO foodPlanToFoodPlanDTO(FoodPlan foodPlan);

//    @Named("foodPlanDTOmeals")
//    default List<MealDTO> foodPlanDTOmeals(FoodPlan foodPlan){
//        List<MealDTO> mealDTOs= new ArrayList<>();
//        for (Meal meal: foodPlan.getMeals()) {
//            MealDTO mealDTO = new MealDTO();
//            mealDTO.setId(meal.getId());
//            mealDTO.setFood(FoodMapper.INSTANCE.foodToFoodDTO(meal.getFood()));
//            mealDTO.setWeight(meal.getWeight());
//            mealDTO.setTimesOfDay(meal.getTimesOfDay());
//            mealDTOs.add(mealDTO);
//        }
//        return mealDTOs;
//    }

}
