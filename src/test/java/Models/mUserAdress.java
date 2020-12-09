package models;

import lombok.*;

@Data
public class MUserAdress {

    private String street, suite, city, zipcode;
    private MAddressGeo geo;

}
