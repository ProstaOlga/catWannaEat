package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.FoodBag;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodBagMapper {

    FoodBagMapper INSTANCE = Mappers.getMapper(FoodBagMapper.class);

    @Mapping(source = "packingDate", dateFormat = "yyyy-MM-dd", target = "packingDate")
    FoodBag foodBagDTOtoFoodBag(FoodBagDTO foodBagDTO);


    @Mapping(source = "packingDate", dateFormat = "yyyy-MM-dd", target = "packingDate")
    @Mapping(source = "food.id", target = "foodId")
    FoodBagDTO foodBagToFoodBagDTO(FoodBag foodBag);



}
