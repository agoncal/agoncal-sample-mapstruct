package org.agoncal.sample.mapstruct.relationflat.mapper;

import org.agoncal.sample.mapstruct.relationflat.domain.Organisation;
import org.agoncal.sample.mapstruct.relationflat.dto.OrganisationWithAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Organisation and its DTO OrganisationDTO.
 */
@Mapper
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
