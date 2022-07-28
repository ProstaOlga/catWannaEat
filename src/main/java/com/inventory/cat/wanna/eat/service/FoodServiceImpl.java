package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.mappers.FoodMapper;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.service.api.FoodService;
import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.models.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepo foodRepo;

    @Override
    public List<FoodDTO> getFoodTypes() {
        List<Food> foods = (List<Food>) foodRepo.findAll();
        return foods.stream()
                .map(FoodMapper.INSTANCE::foodToFoodDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createFoodType(FoodDTO food) {
        foodRepo.save(FoodMapper.INSTANCE.foodDTOtoFood(food));
    }

    @Override
    public FoodDTO getFoodTypeById(Long id) {
        return FoodMapper.INSTANCE.foodToFoodDTO(foodRepo.getById(id));
    }

    @Override
    public void removeFoodType(Long id) {
        foodRepo.deleteById(id);
    }
}
