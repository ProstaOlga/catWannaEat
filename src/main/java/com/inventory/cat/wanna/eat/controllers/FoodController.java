package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.service.api.FoodService;
import com.inventory.cat.wanna.eat.models.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @GetMapping()
    public HttpEntity<List<Food>> view() {
        return new HttpEntity<>(foodService.getFoodTypes());
    }

    @GetMapping("/{id}")
    public HttpEntity<Food> view(@PathVariable long id) {
        return new HttpEntity<>(foodService.getFoodTypeById(id));
    }

    @PutMapping()
    public void create(@RequestBody FoodDTO food) {
        foodService.createFoodType(food);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        foodService.removeFoodType(id);
    }
}
