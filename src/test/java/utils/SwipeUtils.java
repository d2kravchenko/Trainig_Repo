package utils;

import aquality.appium.mobile.application.AqualityServices;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class SwipeUtils {

    public static void swipeToRightTab(){
        double startPointX = 0.9;
        double startPointY = 0.5;
        double endPointX = 0.1;
        double endPointY = 0.5;
        Dimension size = AqualityServices.getApplication().getDriver().manage().window().getSize();
        Point startPoint = new Point((int) (size.width * startPointX), (int) (size.height * startPointY));
        Point endPoint = new Point((int) (size.width * endPointX), (int) (size.height * endPointY));
        AqualityServices.getTouchActions().swipe(startPoint, endPoint);
    }


}
