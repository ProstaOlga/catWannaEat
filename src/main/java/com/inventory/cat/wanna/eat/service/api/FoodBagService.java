package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.FoodBag;

import java.util.List;

public interface FoodBagService {
    /**
     * Получить список пакетов
     */
    List<FoodBag> getFoodBags();

    /**
     * Поиск пакета по id
     */
    FoodBag getFoodBagById(long id);

    /**
     * Добавить новый пакет
     */
    void createFoodBag(FoodBagDTO foodBag);

    /**
     * Удалить пакет
     */
    void removeFoodBag(long id);

}
