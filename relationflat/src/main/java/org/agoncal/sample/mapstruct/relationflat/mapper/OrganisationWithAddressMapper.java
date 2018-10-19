package org.agoncal.sample.mapstruct.relationflat.mapper;

import org.agoncal.sample.mapstruct.relationflat.domain.Organisation;
import org.agoncal.sample.mapstruct.relationflat.dto.OrganisationWithAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity Organisation and its DTO OrganisationDTO.
 */
@Mapper
public interface OrganisationWithAddressMapper extends EntityMapper<OrganisationWithAddressDTO, Organisation> {

    OrganisationWithAddressMapper INSTANCE = Mappers.getMapper( OrganisationWithAddressMapper.class );

    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "address.street", target = "addressStreet")
    @Mapping(source = "address.street2", target = "addressStreet2")
    @Mapping(source = "address.city", target = "addressCity")
    @Mapping(source = "address.state", target = "addressState")
    @Mapping(source = "address.zipCode", target = "addressZipCode")
    @Mapping(source = "address.country.id", target = "countryId")
    @Mapping(source = "address.country.name", target = "countryName")
    OrganisationWithAddressDTO toDto(Organisation organisation);

    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressStreet2", target = "address.street2")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressState", target = "address.state")
    @Mapping(source = "addressZipCode", target = "address.zipCode")
    @Mapping(source = "countryId", target = "address.country.id")
    @Mapping(source = "countryName", target = "address.country.name")
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
