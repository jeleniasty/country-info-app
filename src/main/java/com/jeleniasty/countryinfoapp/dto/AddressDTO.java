package com.jeleniasty.countryinfoapp.dto;


import java.util.Objects;

public record AddressDTO(int id, String uid, String city, String street_name, String street_address,
                         String secondary_address, String building_number, String mail_box, String community,
                         String zip_code, String zip, String postcode, String time_zone, String street_suffix,
                         String city_suffix, String city_prefix, String state, String state_abbr, String country,
                         String country_code, String latitude, String longitude, String full_address) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return id == that.id && Objects.equals(uid, that.uid) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid);
    }
}

