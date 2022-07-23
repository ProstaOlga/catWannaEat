package com.inventory.cat.wanna.eat.service.api;


import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;

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
     * Создать новый план питания
     */
    void createFoodPlan(FoodPlanDTO foodPlan);

    /**
     * Удалить план питания
     */
    void removeFoodPlan(long id);

    /**
     * Изменить текущий план питания
     */
    void changeCurrentFoodPlan(long id);






}
