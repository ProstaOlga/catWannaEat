package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.models.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);


    Food foodDTOtoFood(FoodDTO foodDTO);


    FoodDTO foodToFoodDTO(Food food);
}
