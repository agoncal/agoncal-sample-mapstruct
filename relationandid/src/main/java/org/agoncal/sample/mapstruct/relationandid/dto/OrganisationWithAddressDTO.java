package org.agoncal.sample.mapstruct.relationandid.dto;

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
    private AddressDTO address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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
