package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.service.api.FoodPlanService;
import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cat/{catid}/foodplan")
public class FoodPlanController {

    private final FoodPlanService foodPlanService;

    @GetMapping()
    public HttpEntity<List<FoodPlan>> view(){
        return new HttpEntity<>(foodPlanService.getFoodPlans());
    }

    @GetMapping("/{id}")
    public HttpEntity<FoodPlan> view(@PathVariable long id){
        return new HttpEntity<>(foodPlanService.getFoodPlan(id));
    }

    @PutMapping()
    public void create(FoodPlanDTO foodPlan){
        foodPlanService.createFoodPlan(foodPlan);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        foodPlanService.removeFoodPlan(id);
    }

    @PostMapping("/{id}")
    public void changeCurrentFoodPlan(@PathVariable long id){
        foodPlanService.changeCurrentFoodPlan(id);
    }
}
