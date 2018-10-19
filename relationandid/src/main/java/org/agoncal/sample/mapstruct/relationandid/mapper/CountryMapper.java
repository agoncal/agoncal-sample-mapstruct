package org.agoncal.sample.mapstruct.relationandid.mapper;

import org.agoncal.sample.mapstruct.relationandid.domain.Country;
import org.agoncal.sample.mapstruct.relationandid.dto.CountryDTO;
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
