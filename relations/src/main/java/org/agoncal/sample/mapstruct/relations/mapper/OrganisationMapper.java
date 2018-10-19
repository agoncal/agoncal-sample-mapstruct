package org.agoncal.sample.mapstruct.relations.mapper;

import org.agoncal.sample.mapstruct.relations.domain.Organisation;
import org.agoncal.sample.mapstruct.relations.dto.OrganisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity Organisation and its DTO OrganisationDTO.
 */
@Mapper(uses = {AddressMapper.class})
public interface OrganisationMapper extends EntityMapper<OrganisationDTO, Organisation> {

    OrganisationMapper INSTANCE = Mappers.getMapper( OrganisationMapper.class );

    OrganisationDTO toDto(Organisation organisation);

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
