package com.inventory.cat.wanna.eat.service.api;


import com.inventory.cat.wanna.eat.models.Profile;

public interface FoodConsumerService {

    /**
     * Ежедневное удаление порций еды
     */
    void consumeFood(Profile profile);

}
