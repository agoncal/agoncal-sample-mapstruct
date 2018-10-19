package org.agoncal.sample.mapstruct.relationflat.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Organisation entity.
 */
public class OrganisationWithAddressDTO implements Serializable {

    private Long id;

    private String slug;

    private String name;

    private String description;

    private Long addressId;

    private String addressStreet;

    private String addressStreet2;

    private String addressCity;

    private String addressState;

    private String addressZipCode;

    private Long countryId;

    private String countryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public OrganisationWithAddressDTO slug(String slug) {
        this.slug = slug;
        return this;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public OrganisationWithAddressDTO name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public OrganisationWithAddressDTO description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public OrganisationWithAddressDTO addressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
        return this;
    }

    public String getAddressStreet2() {
        return addressStreet2;
    }

    public void setAddressStreet2(String addressStreet2) {
        this.addressStreet2 = addressStreet2;
    }

    public OrganisationWithAddressDTO addressStreet2(String addressStreet2) {
        this.addressStreet2 = addressStreet2;
        return this;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public OrganisationWithAddressDTO addressCity(String addressCity) {
        this.addressCity = addressCity;
        return this;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public OrganisationWithAddressDTO addressState(String addressState) {
        this.addressState = addressState;
        return this;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public OrganisationWithAddressDTO addressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public OrganisationWithAddressDTO countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrganisationWithAddressDTO organisationDTO = (OrganisationWithAddressDTO) o;
        if (organisationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), organisationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrganisationDTO{" +
            "id=" + getId() +
            ", slug='" + getSlug() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
