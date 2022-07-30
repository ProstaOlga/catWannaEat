package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class FoodBagMapperUtil{
    @Autowired
    FoodRepo foodRepo;

    private static FoodRepo foodRepoStatic;

    @Autowired
    public void setStaticFoodRepo(FoodRepo foodRepo){
        FoodBagMapperUtil.foodRepoStatic = foodRepo;
    }

    public static Food mappedFoodIdToFood(Long foodId){
        return foodRepoStatic.getById(foodId);
    }

}
