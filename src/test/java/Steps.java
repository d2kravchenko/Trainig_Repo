import Models.mUser;
import aquality.selenium.browser.AqualityServices;
import com.google.common.collect.Ordering;
import io.restassured.response.Response;

import java.util.List;

public class Steps {

    public static boolean isSortedNaturalById(Response response){
        List<Integer> jsonResponse = response.jsonPath().getList("id");
        return Ordering.natural().isOrdered(jsonResponse);
    }

    public static mUser findUserById(mUser[] users, int id){

        for (mUser user : users) {
            if (user.getId() == id){
                AqualityServices.getLogger().info("User founded");
                return user;
            }
        }
        AqualityServices.getLogger().warn("No users with Id#" + id + "found");
        return null;
    }
}
