package org.agoncal.sample.mapstruct.relationandid.mapper;

import org.agoncal.sample.mapstruct.relationandid.domain.Organisation;
import org.agoncal.sample.mapstruct.relationandid.dto.OrganisationWithAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Organisation and its DTO OrganisationDTO.
 */
@Mapper(uses = {AddressMapper.class})
public interface OrganisationWithAddressMapper extends EntityMapper<OrganisationWithAddressDTO, Organisation> {

    @Mapping(source = "address.id", target = "addressId")
    OrganisationWithAddressDTO toDto(Organisation organisation);

    @Mapping(source = "addressId", target = "address")
    Organisation toEntity(OrganisationWithAddressDTO organisationWithAddressDTO);

    default Organisation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Organisation organisation = new Organisation();
        organisation.setId(id);
        return organisation;
    }
}
