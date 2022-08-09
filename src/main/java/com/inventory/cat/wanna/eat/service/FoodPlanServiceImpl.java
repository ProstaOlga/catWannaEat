package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.exceptions.NotFoundEntityException;
import com.inventory.cat.wanna.eat.mappers.FoodPlanMapper;
import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.repos.FoodPlanRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.repos.MealRepo;
import com.inventory.cat.wanna.eat.service.api.FoodPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<FoodPlanDTO> getFoodPlans(Long catId) {
        List<FoodPlan> foodPlans = (List<FoodPlan>) catRepo.getById(catId).getFoodPlans();
        return foodPlans.stream()
                .map(FoodPlanMapper.INSTANCE::foodPlanToFoodPlanDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodPlanDTO getFoodPlan(Long id) {
        FoodPlan foodPlan = foodPlanRepo.getById(id);
        if (foodPlan == null) {
            throw new NotFoundEntityException(FoodPlan.class, id);
        }

        return FoodPlanMapper.INSTANCE.foodPlanToFoodPlanDTO(foodPlan);
    }

    @Override
    @Transactional
    public void createFoodPlan(Long catId, FoodPlanDTO foodPlan) {
        FoodPlan eFoodPlan = FoodPlanMapper.INSTANCE.foodPlanDTOtoFoodPlan(foodPlan);
        eFoodPlan.setCat(catRepo.getById(catId));

        if (eFoodPlan.isActive()) {
            finishOtherFoodPlans(eFoodPlan.getCat());
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
    public void updateFoodPlan(FoodPlanDTO foodPlan) {
        FoodPlan eFoodPlan = FoodPlanMapper.INSTANCE.foodPlanDTOtoFoodPlan(foodPlan);

        if (eFoodPlan.isActive()) {
            finishOtherFoodPlans(eFoodPlan.getCat());
        }

        foodPlanRepo.save(eFoodPlan);
        mealRepo.saveAll(eFoodPlan.getMeals());


    }


    private void saveMeals(List<Meal> meals, Long foodPlanId) {
        meals.forEach(meal -> meal.setFoodPlan(foodPlanRepo.getById(foodPlanId)));
        mealRepo.saveAll(meals);
    }


    private void finishOtherFoodPlans(Cat cat) {
//        List<FoodPlan> foodPlans = catRepo.getById(foodplan.getCat().getId()).getFoodPlans();

//        if (foodplan.getId() != null) {
//            foodPlans.stream()
//                    .filter(fp -> !foodplan.getId().equals(fp.getId()))
//                    .peek(fp -> fp.setFinished(LocalDateTime.now()))
//                    .forEach(foodPlanRepo::save);
//        } else  {
//            foodPlans.stream()
//                    .peek(fp -> fp.setFinished(LocalDateTime.now()))
//                    .forEach(foodPlanRepo::save);
//        }
        cat.getFoodPlans().stream()
                .peek(foodPlan -> foodPlan.setFinished(LocalDateTime.now()))
                .forEach(foodPlanRepo::save);



    }


}
