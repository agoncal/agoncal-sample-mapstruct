package org.agoncal.sample.mapstruct.relationflat.mapper;

import org.agoncal.sample.mapstruct.relationflat.domain.Address;
import org.agoncal.sample.mapstruct.relationflat.domain.Country;
import org.agoncal.sample.mapstruct.relationflat.domain.Organisation;
import org.agoncal.sample.mapstruct.relationflat.dto.OrganisationWithAddressDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganisationWithAddressMapperTest {

    private static final String DEFAULT_SLUG = "SLUG";
    private static final String DEFAULT_NAME = "NAME";
    private static final String DEFAULT_DESCRIPTION = "DESC";

    private static final String DEFAULT_STREET = "STREET";
    private static final String DEFAULT_STREET_2 = "STREET2";
    private static final String DEFAULT_CITY = "CITY";
    private static final String DEFAULT_STATE = "STATE";
    private static final String DEFAULT_ZIP_CODE = "ZIP";

    private static final String DEFAULT_COUNTRY = "COUNTRY";

    @Test
    public void domainWithRelationships2FlatDTO() {

        // -- prepare
        Organisation domain = createOrganisation();

        // -- action
        OrganisationWithAddressDTO dto = OrganisationWithAddressMapper.INSTANCE.toDto( domain );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(dto.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(dto.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(dto.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(dto.getAddressId()).isNull();
        assertThat(dto.getAddressStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(dto.getAddressStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(dto.getAddressCity()).isEqualTo(DEFAULT_CITY);
        assertThat(dto.getAddressState()).isEqualTo(DEFAULT_STATE);
        assertThat(dto.getAddressZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(dto.getCountryId()).isNull();
        assertThat(dto.getCountryName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void domainWithNullRelationships2FlatDTO() {

        // -- prepare
        Organisation domain = createOrganisationWithNullRelationships();

        // -- action
        OrganisationWithAddressDTO dto = OrganisationWithAddressMapper.INSTANCE.toDto( domain );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(domain.getAddress()).isNull();
        assertThat(dto).isNotNull();
        assertThat(dto.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(dto.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(dto.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(dto.getAddressId()).isNull();
        assertThat(dto.getAddressStreet()).isNull();
        assertThat(dto.getAddressStreet2()).isNull();
        assertThat(dto.getAddressCity()).isNull();
        assertThat(dto.getAddressState()).isNull();
        assertThat(dto.getAddressZipCode()).isNull();
        assertThat(dto.getCountryId()).isNull();
        assertThat(dto.getCountryName()).isNull();
    }

    @Test
    public void flatDTO2DomainWithRelationships() {

        // -- prepare
        OrganisationWithAddressDTO dto = createOrganisationDTO();

        // -- action
        Organisation domain = OrganisationWithAddressMapper.INSTANCE.toEntity( dto );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(domain.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(domain.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(domain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(domain.getAddress().getId()).isNull();
        assertThat(domain.getAddress().getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(domain.getAddress().getStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(domain.getAddress().getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(domain.getAddress().getState()).isEqualTo(DEFAULT_STATE);
        assertThat(domain.getAddress().getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(domain.getAddress().getCountry().getId()).isNull();
        assertThat(domain.getAddress().getCountry().getName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void flatDTO2DomainWithNullRelationships() {

        // -- prepare
        OrganisationWithAddressDTO dto = createOrganisationDTOWithNullValues();

        // -- action
        Organisation domain = OrganisationWithAddressMapper.INSTANCE.toEntity( dto );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(domain.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(domain.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(domain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        // Because all my address and country attributes are null
        // I would like to have Mapstruct not to instanciate the Address object
        assertThat(domain.getAddress()).isNull();
    }

    private Organisation createOrganisation() {
        Country country = new Country()
                .name(DEFAULT_COUNTRY);
        Address address = new Address()
                .street(DEFAULT_STREET)
                .street2(DEFAULT_STREET_2)
                .city(DEFAULT_CITY)
                .state(DEFAULT_STATE)
                .zipCode(DEFAULT_ZIP_CODE)
                .country(country);
        Organisation organisation = new Organisation()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(address);
        return organisation;
    }

    private Organisation createOrganisationWithNullRelationships() {
        Organisation organisation = new Organisation()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(null);
        return organisation;
    }

    private OrganisationWithAddressDTO createOrganisationDTO() {
        OrganisationWithAddressDTO organisation = new OrganisationWithAddressDTO()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .addressStreet(DEFAULT_STREET)
                .addressStreet2(DEFAULT_STREET_2)
                .addressCity(DEFAULT_CITY)
                .addressState(DEFAULT_STATE)
                .addressZipCode(DEFAULT_ZIP_CODE)
                .countryName(DEFAULT_COUNTRY);
        return organisation;
    }

    private OrganisationWithAddressDTO createOrganisationDTOWithNullValues() {
        OrganisationWithAddressDTO organisation = new OrganisationWithAddressDTO()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION);
        return organisation;
    }
}
