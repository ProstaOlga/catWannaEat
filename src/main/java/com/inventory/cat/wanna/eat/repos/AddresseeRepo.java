package com.inventory.cat.wanna.eat.repos;

import com.inventory.cat.wanna.eat.models.Addressee;
import com.inventory.cat.wanna.eat.models.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresseeRepo extends CrudRepository<Addressee, Long> {

    @Query("SELECT am from addressee am where am.id=?1")
    public Addressee getById(Long id);
}
