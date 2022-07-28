package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends CrudRepository<Meal, Long> {
    @Query("SELECT am from meal am where am.id = :id")
    Meal getById(Long id);
}
