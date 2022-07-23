package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.FoodBag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodBagServiceImpl implements FoodBagService {
    @Override
    public List<FoodBag> getFoodBags() {
        return null;
    }

    @Override
    public FoodBag getFoodBagById(long id) {
        return null;
    }

    @Override
    public void createFoodBag(FoodBagDTO foodBag) {

    }

    @Override
    public void removeFoodBag(long id) {

    }

}
