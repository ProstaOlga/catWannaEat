package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class FoodBagDTO {
    Long id;
    FoodDTO foodType;
    Long amount;
    String packingDate;
}
