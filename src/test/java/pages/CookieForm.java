package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

public class CookieForm extends Form {

    public CookieForm(){  super(By.xpath("//div[@class = 'cookies']"), "Cookies Form"); }

    private final String XPATH_BUTTON_NO = "//button[contains(text(), 'Not really, no')]";

    private final IButton NoButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_NO), "\"No\" Button ");

    public boolean isCookiesFormExists(){ return this.getFormLabel().state().waitForDisplayed(Duration.ofSeconds(2)); }

    public void acceptCookies() {
        if (isCookiesFormExists()) {
            NoButton.click();
        }
    }


}
