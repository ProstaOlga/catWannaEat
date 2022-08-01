package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Long> {

    @Query("select p from profile p where p.id = :id")
    Profile getById(Long id);
}
