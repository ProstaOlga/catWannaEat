package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.models.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatMapper {

    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Cat catDTOtoCat(CatDTO catDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CatDTO catToCatDTO(Cat cat);
}
