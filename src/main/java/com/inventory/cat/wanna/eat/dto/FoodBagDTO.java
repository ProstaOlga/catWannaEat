package com.inventory.cat.wanna.eat.dto;

import java.time.LocalDateTime;

public class FoodBagDTO {
    long id;
    CatDTO cat;
    FoodDTO foodType;
    long amount;
    LocalDateTime packingDate;
}
