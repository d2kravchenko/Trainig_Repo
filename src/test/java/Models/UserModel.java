package models;

import lombok.*;

@EqualsAndHashCode(exclude = "id")
@ToString
@Getter @Setter
public class UserModel {

    private int id;
    private String name, username, email, phone, website;
    private UserAddressModel address;
    private UserCompanyModel company;


}
