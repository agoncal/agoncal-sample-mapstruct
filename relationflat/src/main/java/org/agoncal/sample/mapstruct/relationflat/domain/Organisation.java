package org.agoncal.sample.mapstruct.relationflat.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Organisation.
 */
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String slug;

    private String name;

    private String description;

    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public Organisation slug(String slug) {
        this.slug = slug;
        return this;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public Organisation name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Organisation description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public Organisation address(Address address) {
        this.address = address;
        return this;
    }

    public void setAddress(Address address) {
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
        Organisation organisation = (Organisation) o;
        if (organisation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), organisation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + getId() +
                ", slug='" + getSlug() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
    }
}
