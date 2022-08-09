package com.inventory.cat.wanna.eat.service.api;


import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;

import java.util.List;

public interface FoodPlanService {
    /**
     * Получить список планов
     */
    List<FoodPlanDTO> getFoodPlans(Long catId);

    /**
     * Получить план питания по id
     */
    FoodPlanDTO getFoodPlan(Long id);

    /**
     * Создать новый план питания
     */
    void createFoodPlan(Long catId, FoodPlanDTO foodPlan);

    /**
     * Удалить план питания
     */
    void removeFoodPlan(Long id);

    /**
     * Изменить текущий план питания
     */
    void updateFoodPlan(FoodPlanDTO foodPlan);






}
