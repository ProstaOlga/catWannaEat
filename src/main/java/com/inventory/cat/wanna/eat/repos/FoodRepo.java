package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends CrudRepository<Food, Long> {

    @Query("SELECT am from food am where am.id = :id")
    Food getById(Long id);
}
