package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(exclude = "id")
@ToString
@Getter @Setter
public class UserModel {

    private int id;
    private String name, username, email, phone, website;
    private UserAddressModel address;
    private UserCompanyModel company;


}
