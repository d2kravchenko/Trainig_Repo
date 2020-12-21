package utils;

import aquality.selenium.browser.AqualityServices;
import models.UserModel;

public class SearchHelper {
    public static UserModel findUserById(UserModel[] users, int id){

        for (UserModel user : users) {
            if (user.getId() == id){
                AqualityServices.getLogger().info("User founded");
                return user;
            }
        }
        AqualityServices.getLogger().warn("No USERS with Id#" + id + "found");
        return null;
    }
}
