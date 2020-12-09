package models;

import lombok.*;

@EqualsAndHashCode(exclude = "id")
@ToString
@Getter @Setter
public class MUser {

    private int id;
    private String name, username, email, phone, website;
    private MUserAdress address;
    private MUserCompany company;


}
