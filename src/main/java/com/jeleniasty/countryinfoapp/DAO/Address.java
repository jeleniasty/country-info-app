package com.jeleniasty.countryinfoapp.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

     int id;
     String uid;
     String city;
     String street_name;
     String street_address;
     String secondary_address;
     String building_number;
     String mail_box;
     String community;
     String zip_code;
     String zip;
     String postcode;
     String time_zone;
     String street_suffix;
     String city_suffix;
     String city_prefix;
     String state;
     String state_abbr;
     String country;
     String country_code;
     String latitude;
     String longitude;
     String full_address;

    @Override
    public String toString() {
        return "ID= " + id + "\n" +
                "UID= " + uid + "\n" +
                "City= " + city + "\n" +
                "Street name= " + street_name + "\n" +
                "Street address= " + street_address + "\n" +
                "Secondary address= " + secondary_address + "\n" +
                "Building number= " + building_number + "\n" +
                "Mail box= " + mail_box + "\n" +
                "Community= " + community + "\n" +
                "Zip code= " + zip_code + "\n" +
                "Zip= " + zip + "\n" +
                "Postcode= " + postcode + "\n" +
                "Time zone= " + time_zone + "\n" +
                "Street suffix= " + street_suffix + "\n" +
                "City suffix= " + city_suffix + "\n" +
                "City prefix= " + city_prefix + "\n" +
                "State= " + state + "\n" +
                "State abbr= " + state_abbr + "\n" +
                "Country= " + country + "\n" +
                "Country code= " + country_code + "\n" +
                "Latitude= " + latitude + "\n" +
                "Longitude= " + longitude + "\n" +
                "Full address= " + full_address + "\n";
    }
}
