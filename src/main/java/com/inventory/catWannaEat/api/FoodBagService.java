package com.inventory.catWannaEat.api;

import com.inventory.catWannaEat.models.Food;
import com.inventory.catWannaEat.models.FoodBag;

import java.time.LocalDateTime;
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
    void addFoodBag(Food foodType, long amount);

    /**
     * Удалить пакет
     */
    void removeFoodBag(long id);

    /**
     * Именить пакет
     */

    /**
     * Проверить количество еды в пакете
     */
    long getAmountInBag(long id);

    /**
     * Получить дату сортировки пакета
     */
    LocalDateTime getPackingDate(long id);
}
