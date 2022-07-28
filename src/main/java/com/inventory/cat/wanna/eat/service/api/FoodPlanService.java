package com.inventory.cat.wanna.eat.service.api;


import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.models.FoodPlan;

import java.util.List;

public interface FoodPlanService {
    /**
     * Получить список планов
     */
    List<FoodPlanDTO> getFoodPlans();

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
    void updateCurrentFoodPlan(Long id);






}
