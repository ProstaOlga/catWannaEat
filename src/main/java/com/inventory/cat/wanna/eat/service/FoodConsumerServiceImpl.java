package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.*;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.service.api.FoodConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodConsumerServiceImpl implements FoodConsumerService {

    private final FoodBagService foodBagService;

    @Override
    @Transactional
    public void consumeFood(Profile profile) {
        profile.getCats().stream()
                .map(Cat::getCurrentFoodPlan)
                .forEach(foodPlan -> applyFoodPlan(foodPlan, profile.getFoodBags()));
    }

    private void applyFoodPlan(FoodPlan foodPlan, List<FoodBag> foodBags) {
        List<Food> foods = foodPlan.getFoods();
        foods.forEach(food -> removeFoodPortion(food, foodBags));
    }

    private void removeFoodPortion(Food food, List<FoodBag> foodBags) {
        foodBags.stream()
                .filter(item -> item.getFood().getId().equals(food.getId()))
                .filter(item -> item.getAmount() > 0)
                .min(Comparator.comparing(FoodBag::getPackingDate))
                .stream()
                .peek(FoodBag::reduceAmount)
                .peek(foodBagService::updateFoodBag)
                .filter(item -> item.getAmount() <= 0)
                .forEach(this::removeEmptyFoodBag);
    }

    private void removeEmptyFoodBag(FoodBag foodBag) {
        foodBagService.removeFoodBag(foodBag.getId());
    }

}
