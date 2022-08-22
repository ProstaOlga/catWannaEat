package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatMapper {

    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    Cat catDTOtoCat(CatDTO catDTO);

    CatDTO catToCatDTO(Cat cat);

}
