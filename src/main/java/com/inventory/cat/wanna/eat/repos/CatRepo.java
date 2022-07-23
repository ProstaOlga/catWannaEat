package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends CrudRepository<Cat, Long> {

    @Query("SELECT am from cat am where am.id=?1")
    public Cat getById(long id);
}
