package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.models.FoodBag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodBagMapper {

    FoodBagMapper INSTANCE = Mappers.getMapper(FoodBagMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "foodType", target = "foodType")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "packingDate", dateFormat = "yyyy-MM-dd", target = "packingDate")
    FoodBag foodBagDTOtoFoodBag(FoodBagDTO foodBagDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "foodType", target = "foodType")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "packingDate", dateFormat = "yyyy-MM-dd", target = "packingDate")
    FoodBagDTO foodBagToFoodBagDTO(FoodBag foodBag);

}
