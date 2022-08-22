package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {

    @Query("SELECT am from cat am where am.id=?1")
    Cat getById(long id);

    Optional<Cat> findCatById(Long id);

}
