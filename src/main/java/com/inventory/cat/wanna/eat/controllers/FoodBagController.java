package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cat/foodbag")
public class FoodBagController {
    private final FoodBagService foodBagService;

    @GetMapping()
    public HttpEntity<List<FoodBagDTO>> view(@PathVariable long catId) {
        return new HttpEntity<>(foodBagService.getFoodBags());
    }


    @GetMapping("/{id}")
    public HttpEntity<FoodBagDTO> view( @PathVariable Long id) {
        return new HttpEntity<>(foodBagService.getFoodBagById(id));
    }

    @PostMapping()
    public void create(@RequestBody FoodBagDTO foodBag) {
        foodBagService.createFoodBag(foodBag);
    }

    @DeleteMapping("/{id}")
    public void remove( @PathVariable Long id) {
        foodBagService.removeFoodBag(id);
    }

    @PutMapping("/{id}")
    public void update( @PathVariable Long id, @RequestBody FoodBagDTO foodBag) {
        foodBagService.updateFoodBag(id, foodBag);
    }

}
