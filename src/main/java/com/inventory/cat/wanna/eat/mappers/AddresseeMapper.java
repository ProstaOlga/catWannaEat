package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.AddresseeDTO;
import com.inventory.cat.wanna.eat.models.Addressee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddresseeMapper {

    AddresseeMapper INSTANCE = Mappers.getMapper(AddresseeMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    Addressee addresseeDTOtoAddressee(AddresseeDTO addresseeDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    AddresseeDTO addresseeToAddresseeDTO(Addressee addressee);
}
