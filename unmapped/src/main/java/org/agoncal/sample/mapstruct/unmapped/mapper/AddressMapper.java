package org.agoncal.sample.mapstruct.unmapped.mapper;

import org.agoncal.sample.mapstruct.unmapped.domain.Address;
import org.agoncal.sample.mapstruct.unmapped.dto.AddressDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Address and its DTO AddressDTO.
 */
@Mapper(uses = {CountryMapper.class})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

    AddressDTO toDto(Address address);

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
