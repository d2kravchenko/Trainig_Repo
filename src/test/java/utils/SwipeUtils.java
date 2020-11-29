package utils;

import aquality.appium.mobile.application.AqualityServices;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class SwipeUtils {

    public static void swipeToRightTab(){

        Dimension size = AqualityServices.getApplication().getDriver().manage().window().getSize();
        Point p = new Point((int) (size.width * 0.9), (int) (size.height * 0.5));
        Point p2 = new Point((int) (size.width * 0.1), (int) (size.height * 0.5));
        AqualityServices.getTouchActions().swipe(p, p2);
    }


}
