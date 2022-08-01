package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import com.inventory.cat.wanna.eat.models.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);


    Profile addresseeDTOtoAddressee(ProfileDTO profileDTO);


    ProfileDTO addresseeToAddresseeDTO(Profile profile);
}
