package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.models.Food;

import java.util.List;

public interface FoodService {

    /**
     * Получить список типов еды
     */
    List<FoodDTO> getFoodTypes();

    /**
     * Получить тип еды по id
     */
    FoodDTO getFoodTypeById(Long id);

    /**
     * Добавить новый тип еды
     */
    void createFoodType(FoodDTO food);

    /**
     * Удалить тип еды
     */
    void removeFoodType(Long id);

}
