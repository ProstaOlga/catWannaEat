package com.inventory.catWannaEat.api;

import com.inventory.catWannaEat.models.Food;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public interface FoodService {

    /**
     * Получить список типов еды
     */
    List<Food> getFoodTypes();

    /**
     * Добавить новый тип еды
     */
    void addNewFoodType(String name);

    /**
     * Получить тип еды по id
     */
    Food getFoodTypeById(long id);

    /**
     * Удалить тип еды
     */
    void removeFoodType(long id);

}
