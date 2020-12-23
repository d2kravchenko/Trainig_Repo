package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

public class CookieForm extends Form {

    public CookieForm(){  super(By.xpath("//div[@class = 'cookies']"), "Cookies Form"); }

    /*Xpath*/

    private final String XPATH_BUTTON_No = "//button[contains(text(), 'Not really, no')]";

    /*Elements*/

    private final IButton NoButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_No), "\"No\" Button ");

    /*Methods*/

    public boolean isCookiesFormExists(){ return this.getFormLabel().state().waitForDisplayed(Duration.ofSeconds(2)); }

    public void acceptCookies() {
        if (isCookiesFormExists()) {
            NoButton.click();
        }
    }


}
