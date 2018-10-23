package org.agoncal.sample.mapstruct.unmapped.mapper;

import org.agoncal.sample.mapstruct.unmapped.domain.Country;
import org.agoncal.sample.mapstruct.unmapped.dto.CountryDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Country and its DTO CountryDTO.
 */
@Mapper
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {



    default Country fromId(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }
}
