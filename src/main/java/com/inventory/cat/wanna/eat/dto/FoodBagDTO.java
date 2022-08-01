package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodBagDTO {
    private Long id;
//    private FoodDTO food;
    private Long foodId;
    private Long amount;
    private String packingDate;
}
