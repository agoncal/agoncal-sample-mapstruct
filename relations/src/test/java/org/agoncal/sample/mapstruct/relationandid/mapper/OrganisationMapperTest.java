package org.agoncal.sample.mapstruct.relationandid.mapper;

import org.agoncal.sample.mapstruct.relations.domain.Address;
import org.agoncal.sample.mapstruct.relations.domain.Country;
import org.agoncal.sample.mapstruct.relations.domain.Organisation;
import org.agoncal.sample.mapstruct.relations.dto.AddressDTO;
import org.agoncal.sample.mapstruct.relations.dto.CountryDTO;
import org.agoncal.sample.mapstruct.relations.dto.OrganisationDTO;
import org.agoncal.sample.mapstruct.relations.mapper.OrganisationMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganisationMapperTest {

    private static final Long DEFAULT_ID = 42L;

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
    public void domain2DTO() {

        // -- prepare
        Organisation domain = createOrganisation();

        // -- action
        OrganisationDTO dto = OrganisationMapper.INSTANCE.toDto( domain );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(dto.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(dto.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(dto.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(dto.getAddress()).isNotNull();
        assertThat(dto.getAddress().getId()).isNull();
        assertThat(dto.getAddress().getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(dto.getAddress().getStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(dto.getAddress().getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(dto.getAddress().getState()).isEqualTo(DEFAULT_STATE);
        assertThat(dto.getAddress().getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(dto.getAddress().getCountry()).isNotNull();
        assertThat(dto.getAddress().getCountry().getId()).isNull();
        assertThat(dto.getAddress().getCountry().getName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void domainWithID2DTO() {

        // -- prepare
        Organisation domain = createOrganisation();
        domain.setId(DEFAULT_ID);
        domain.getAddress().setId(DEFAULT_ID);
        domain.getAddress().getCountry().setId(DEFAULT_ID);

        // -- action
        OrganisationDTO dto = OrganisationMapper.INSTANCE.toDto( domain );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(dto.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(dto.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(dto.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(dto.getAddress()).isNotNull();
        assertThat(dto.getAddress().getId()).isEqualTo(DEFAULT_ID);
        assertThat(dto.getAddress().getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(dto.getAddress().getStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(dto.getAddress().getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(dto.getAddress().getState()).isEqualTo(DEFAULT_STATE);
        assertThat(dto.getAddress().getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(dto.getAddress().getCountry()).isNotNull();
        assertThat(dto.getAddress().getCountry().getId()).isEqualTo(DEFAULT_ID);
        assertThat(dto.getAddress().getCountry().getName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void domainWithNullRelationships2DTO() {

        // -- prepare
        Organisation domain = createOrganisationWithNullRelationships();

        // -- action
        OrganisationDTO dto = OrganisationMapper.INSTANCE.toDto( domain );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(domain.getAddress()).isNull();
        assertThat(dto).isNotNull();
        assertThat(dto.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(dto.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(dto.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(dto.getAddress()).isNull();
    }

    @Test
    public void dto2Domain() {

        // -- prepare
        OrganisationDTO dto = createOrganisationDTO();

        // -- action
        Organisation domain = OrganisationMapper.INSTANCE.toEntity( dto );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(domain.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(domain.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(domain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(domain.getAddress()).isNotNull();
        assertThat(domain.getAddress().getId()).isNull();
        assertThat(domain.getAddress().getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(domain.getAddress().getStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(domain.getAddress().getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(domain.getAddress().getState()).isEqualTo(DEFAULT_STATE);
        assertThat(domain.getAddress().getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(domain.getAddress().getCountry()).isNotNull();
        assertThat(domain.getAddress().getCountry().getId()).isNull();
        assertThat(domain.getAddress().getCountry().getName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void dtoWithID2Domain() {

        // -- prepare
        OrganisationDTO dto = createOrganisationDTO();
        dto.setId(DEFAULT_ID);
        dto.getAddress().setId(DEFAULT_ID);
        dto.getAddress().getCountry().setId(DEFAULT_ID);

        // -- action
        Organisation domain = OrganisationMapper.INSTANCE.toEntity( dto );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(domain.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(domain.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(domain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(domain.getAddress()).isNotNull();
        assertThat(domain.getAddress().getId()).isEqualTo(DEFAULT_ID);
        assertThat(domain.getAddress().getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(domain.getAddress().getStreet2()).isEqualTo(DEFAULT_STREET_2);
        assertThat(domain.getAddress().getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(domain.getAddress().getState()).isEqualTo(DEFAULT_STATE);
        assertThat(domain.getAddress().getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(domain.getAddress().getCountry()).isNotNull();
        assertThat(domain.getAddress().getCountry().getId()).isEqualTo(DEFAULT_ID);
        assertThat(domain.getAddress().getCountry().getName()).isEqualTo(DEFAULT_COUNTRY);
    }

    @Test
    public void dtoWithNullRelationships2domain() {

        // -- prepare
        OrganisationDTO dto = createOrganisationDTOWithNullRelationships();

        // -- action
        Organisation domain = OrganisationMapper.INSTANCE.toEntity( dto );

        // -- result
        assertThat(domain).isNotNull();
        assertThat(dto).isNotNull();
        assertThat(domain.getSlug()).isEqualTo(DEFAULT_SLUG);
        assertThat(domain.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(domain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
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

    private OrganisationDTO createOrganisationDTO() {
        CountryDTO country = new CountryDTO()
                .name(DEFAULT_COUNTRY);
        AddressDTO address = new AddressDTO()
                .street(DEFAULT_STREET)
                .street2(DEFAULT_STREET_2)
                .city(DEFAULT_CITY)
                .state(DEFAULT_STATE)
                .zipCode(DEFAULT_ZIP_CODE)
                .country(country);
        OrganisationDTO organisation = new OrganisationDTO()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(address);
        return organisation;
    }

    private OrganisationDTO createOrganisationDTOWithNullRelationships() {
        OrganisationDTO organisation = new OrganisationDTO()
                .slug(DEFAULT_SLUG)
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .address(null);
        return organisation;
    }
}
