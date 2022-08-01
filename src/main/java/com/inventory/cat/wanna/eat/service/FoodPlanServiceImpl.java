package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.mappers.FoodPlanMapper;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.repos.FoodPlanRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.repos.MealRepo;
import com.inventory.cat.wanna.eat.service.api.FoodPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodPlanServiceImpl implements FoodPlanService {

    private final FoodPlanRepo foodPlanRepo;
    private final CatRepo catRepo;
    private final MealRepo mealRepo;
    private final FoodRepo foodRepo;

    @Override
    public List<FoodPlanDTO> getFoodPlans() {
        List<FoodPlan> foodPlans = (List<FoodPlan>) foodPlanRepo.findAll();
        return foodPlans.stream()
                .map(FoodPlanMapper.INSTANCE::foodPlanToFoodPlanDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodPlanDTO getFoodPlan(Long id) {
        return FoodPlanMapper.INSTANCE.foodPlanToFoodPlanDTO(foodPlanRepo.getById(id));
    }

    @Override
    public void createFoodPlan(Long catId, FoodPlanDTO foodPlan) {
        FoodPlan eFoodPlan = FoodPlanMapper.INSTANCE.foodPlanDTOtoFoodPlan(foodPlan);
        eFoodPlan.setCat(catRepo.getById(catId));

        if (eFoodPlan.isCurrent()) {
            makeCurrent(eFoodPlan);
        }

        foodPlanRepo.save(eFoodPlan);
        Long foodPlanId = eFoodPlan.getId();
        saveMeals(eFoodPlan.getMeals(), foodPlanId);
    }


    @Override
    public void removeFoodPlan(Long id) {
        foodPlanRepo.deleteById(id);

    }

    @Override
    public void updateCurrentFoodPlan(Long id) {

    }


    private void saveMeals(List<Meal> meals, Long foodPlanId) {
        meals.forEach(meal -> meal.setFoodPlan(foodPlanRepo.getById(foodPlanId)));
        mealRepo.saveAll(meals);
    }


    private void makeCurrent(FoodPlan newFoodPlan) {
        newFoodPlan.setCurrent(true);
        newFoodPlan.setStarted(LocalDateTime.now());
        newFoodPlan.setFinished(null);

        List<FoodPlan> foodPlans = (List<FoodPlan>) foodPlanRepo.findAll();

        if (!foodPlans.isEmpty()) {
            foodPlans.stream().filter(fp -> newFoodPlan.getId() != fp.getId())
                    .peek(fp -> fp.setFinished(LocalDateTime.now()))
                    .peek(fp -> fp.setCurrent(false))
                    .forEach(foodPlanRepo::save);
        }
    }


}
