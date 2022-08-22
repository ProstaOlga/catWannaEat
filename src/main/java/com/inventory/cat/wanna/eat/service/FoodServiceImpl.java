package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.exceptions.NotFoundEntityException;
import com.inventory.cat.wanna.eat.mappers.FoodMapper;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.FoodPlanRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.service.api.FoodService;
import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepo foodRepo;
    private final FoodPlanRepo foodPlanRepo;

    @Override
    public List<FoodDTO> getFoodTypes() {
        Profile profile = ProfileUtil.getCurrentProfile();
        List<Food> foods = foodRepo.getFoodsByProfile_Id(profile.getId());

        return foods.stream()
                .map(FoodMapper.INSTANCE::foodToFoodDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createFoodType(FoodDTO food) {
        foodRepo.save(FoodMapper.INSTANCE.foodDTOtoFood(food));
    }

    @Override
    @PreAuthorize("@authorizeCheck.food(#id)")
    public FoodDTO getFoodTypeById(Long id) {
        Food food = foodRepo.getById(id);
        if (food == null) {
            throw new NotFoundEntityException(Food.class, id);
        }

        return FoodMapper.INSTANCE.foodToFoodDTO(food);
    }

    @Override
    public void removeFoodType(Long id) {
        List<FoodPlan> foodPlans = getAvailableFoodInFoodPlans(id);
        if (foodPlans.isEmpty()){
            foodRepo.deleteById(id);
        }
    }

    private List<FoodPlan> getAvailableFoodInFoodPlans(Long id){
        List<FoodPlan> foodPlans = (List<FoodPlan>) foodPlanRepo.findAll();

        return foodPlans.stream()
                .filter(foodPlan -> checkAvailableFoodInMeals(foodPlan.getMeals(), id))
                .collect(Collectors.toList());
    }

    private boolean checkAvailableFoodInMeals(List<Meal> meals, Long id) {
        return  meals.stream().anyMatch(
                meal -> meal.getFood().getId().equals(id)
        );
    }
}
