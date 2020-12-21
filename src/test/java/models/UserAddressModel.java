package models;

import lombok.Data;

@Data
public class UserAddressModel {

    private String street, suite, city, zipcode;
    private AddressGeoModel geo;

}
