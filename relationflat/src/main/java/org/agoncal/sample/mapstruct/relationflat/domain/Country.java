package org.agoncal.sample.mapstruct.relationflat.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * iso2 codes are two-letter country codes defined in ISO 3166-1
 * iso3 codes are three-letter country codes defined in ISO 3166-1
 * M.49 is a standard for area codes used by the United Nations for statistical purposes
 * dial number to dial for phone numbers
 * tld  top-level domains
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        if (country.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), country.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
