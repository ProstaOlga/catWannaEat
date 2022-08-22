package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {

    Optional<Profile> findById(Long id);

    Optional<Profile> findByName(String name);
}
