package utils;

import aquality.selenium.browser.AqualityServices;
import models.MUser;

public class SearchHelper {
    public static MUser findUserById(MUser[] users, int id){

        for (MUser user : users) {
            if (user.getId() == id){
                AqualityServices.getLogger().info("User founded");
                return user;
            }
        }
        AqualityServices.getLogger().warn("No USERS with Id#" + id + "found");
        return null;
    }
}
