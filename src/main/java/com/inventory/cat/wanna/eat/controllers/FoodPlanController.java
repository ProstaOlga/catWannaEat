package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.service.api.FoodPlanService;
import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cat/{catId}/foodplan")
public class FoodPlanController {

    private final FoodPlanService foodPlanService;

    @GetMapping()
    public HttpEntity<List<FoodPlanDTO>> view(@PathVariable Long catId){
        return new HttpEntity<>(foodPlanService.getFoodPlans(catId));
    }

    @GetMapping("/{id}")
    public HttpEntity<FoodPlanDTO> view(@PathVariable Long catId, @PathVariable Long id){
        return new HttpEntity<>(foodPlanService.getFoodPlan(id));
    }

    @PostMapping()
    public void create(@PathVariable Long catId, @RequestBody FoodPlanDTO foodPlan){
        foodPlanService.createFoodPlan(catId, foodPlan);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        foodPlanService.removeFoodPlan(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody FoodPlanDTO foodPlan){
        foodPlanService.updateFoodPlan(foodPlan);
    }
}
