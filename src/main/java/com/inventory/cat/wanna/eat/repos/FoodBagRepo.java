package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.FoodBag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodBagRepo extends CrudRepository<FoodBag, Long> {

    @Query("SELECT am from food_bag am where am.id=?1")
    public FoodBag getById(Long id);

    public List<FoodBag> getFoodBagsByProfile_Id(Long id);
}
