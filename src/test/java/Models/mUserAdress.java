package Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter @Setter
public class mUserAdress {

    private String street, suite, city, zipcode;
    private mAddressGeo geo;

}
