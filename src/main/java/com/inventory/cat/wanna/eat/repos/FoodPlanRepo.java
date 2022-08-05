package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.FoodPlan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPlanRepo extends CrudRepository<FoodPlan, Long> {
    @Query("SELECT am from food_plan am where am.id=?1")
    FoodPlan getById(Long id);

}
