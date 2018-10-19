package org.agoncal.sample.mapstruct.relationandid.mapper;

import org.agoncal.sample.mapstruct.relationandid.domain.Organisation;
import org.agoncal.sample.mapstruct.relationandid.dto.OrganisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity Organisation and its DTO OrganisationDTO.
 */
@Mapper(uses = {AddressMapper.class})
public interface OrganisationMapper extends EntityMapper<OrganisationDTO, Organisation> {

    OrganisationMapper INSTANCE = Mappers.getMapper( OrganisationMapper.class );

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "address", target = "address")
    OrganisationDTO toDto(Organisation organisation);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "address", target = "address")
    Organisation toEntity(OrganisationDTO organisationDTO);

    default Organisation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Organisation organisation = new Organisation();
        organisation.setId(id);
        return organisation;
    }
}
