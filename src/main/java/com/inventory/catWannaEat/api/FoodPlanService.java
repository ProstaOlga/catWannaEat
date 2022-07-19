package com.inventory.catWannaEat.api;


import com.inventory.catWannaEat.models.FoodPlan;

import java.util.List;

public interface FoodPlanService {
    /**
     * Получить список планов
     */
    List<FoodPlan> getFoodPlans();

    /**
     * Получить план питания по id
     */
    FoodPlan getFoodPlan(long id);

    /**
     * Получить текущий план питания
     */
    FoodPlan getCurrentFoodPlan();

    /**
     * Изменить текущий план питания
     */
    void changeCurrentFoodPlan(long id);

    /**
     * Удалить план питания
     */
    void removeFoodPlan(long id);

    /**
     * Создать новый план питания
     */
    void createFoodPlan();


}
