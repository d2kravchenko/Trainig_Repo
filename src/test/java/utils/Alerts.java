package utils;

import aquality.appium.mobile.application.AqualityServices;
import org.openqa.selenium.NoAlertPresentException;

public class Alerts {

    public static void ifAlertThenAccept(){
        try {
            AqualityServices.getApplication().getDriver().switchTo().alert().accept();
            AqualityServices.getLogger().debug("Alert accepted");
        } catch (NoAlertPresentException e) {
            AqualityServices.getLogger().debug("No alert");
        }
    }
}
