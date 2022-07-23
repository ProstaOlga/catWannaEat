package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.service.api.FoodPlanService;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodPlanServiceImpl implements FoodPlanService {
    @Override
    public List<FoodPlan> getFoodPlans() {
        return null;
    }

    @Override
    public FoodPlan getFoodPlan(long id) {
        return null;
    }


    @Override
    public void changeCurrentFoodPlan(long id) {

    }

    @Override
    public void removeFoodPlan(long id) {

    }

    @Override
    public void createFoodPlan(FoodPlanDTO foodPlan) {

    }
}
