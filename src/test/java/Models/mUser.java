package Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(exclude = "id")
@ToString
@Getter @Setter
public class mUser {

    private int id;
    private String name, username, email, phone, website;
    private mUserAdress address;
    private mUserCompany company;


}
