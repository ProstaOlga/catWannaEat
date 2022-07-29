package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodBagDTO {
    private Long id;
    private FoodDTO foodType;
    private Long amount;
    private String packingDate;
    private ProfileDTO user;
}
