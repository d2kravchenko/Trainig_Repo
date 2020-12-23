package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    public HomePage() { super(By.xpath("//button[@class = 'start__button']"), "Home Page > Fake Start Button"); }

    /*Xpath*/
    private static final String XPATH_START_BUTTON = "//a[@class = 'start__link']";

    /*Elements*/
    private static final IButton StartButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_START_BUTTON), "Real Start button");

    /*Methods*/

    public static void clickStartButton(){ StartButton.click(); }

    public static boolean pageOpened(){ return StartButton.getElement().isDisplayed();  }
}
