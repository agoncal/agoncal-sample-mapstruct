package org.agoncal.sample.mapstruct.relationandid.mapper;

import org.agoncal.sample.mapstruct.relationandid.domain.Address;
import org.agoncal.sample.mapstruct.relationandid.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Address and its DTO AddressDTO.
 */
@Mapper
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    AddressDTO toDto(Address address);

    @Mapping(source = "countryId", target = "country")
    Address toEntity(AddressDTO addressDTO);

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}
