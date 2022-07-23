package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.service.api.FoodService;
import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.models.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Override
    public List<Food> getFoodTypes() {
        return null;
    }

    @Override
    public void createFoodType(FoodDTO food) {

    }

    @Override
    public Food getFoodTypeById(long id) {
        return null;
    }

    @Override
    public void removeFoodType(long id) {

    }
}
