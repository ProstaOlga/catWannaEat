package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.models.Profile;

import java.util.HashMap;
import java.util.List;

public interface FoodBagService {
    /**
     * Получить список пакетов
     */
    List<FoodBagDTO> getFoodBags();

    /**
     * Поиск пакета по id
     */
    FoodBagDTO getFoodBagById(Long id);

    /**
     * Добавить новый пакет
     */
    void createFoodBag(FoodBagDTO foodBag);

    /**
     * Удалить пакет
     */
    void removeFoodBag(Long id);

    /**
     * Изменить пакет
     */
    void updateFoodBag(Long id, FoodBagDTO foodBag);

    void updateFoodBag(FoodBag foodBag);

    HashMap<String, Long> getRunningOutFoods(Profile profile);
}
