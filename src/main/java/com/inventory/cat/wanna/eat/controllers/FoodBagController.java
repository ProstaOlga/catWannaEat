package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.FoodBag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cat/{catId}/foodbag")
public class FoodBagController {
    private final FoodBagService foodBagService;

    @GetMapping()
    public HttpEntity<List<FoodBag>> view(@PathVariable long catId) {
        return new HttpEntity<>(foodBagService.getFoodBags());
    }


    @GetMapping("/{id}")
    public HttpEntity<FoodBag> view(@PathVariable long catId, @PathVariable long id) {
        return new HttpEntity<>(foodBagService.getFoodBagById(id));
    }

    @PutMapping()
    public void create(@PathVariable long catId, @RequestBody FoodBagDTO foodBag) {
        foodBagService.createFoodBag(foodBag);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long catId, @PathVariable long id) {
        foodBagService.removeFoodBag(id);
    }

}
