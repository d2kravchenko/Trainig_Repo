package screenObjects.loginScreenObjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.time.Duration;

public class AccountAccessScreen extends Screen {

    public AccountAccessScreen() { super(By.xpath("//android.view.View[@content-desc = 'Account access']"), "Account access screen");  }

    private final int WAIT_ACCOUNT_ACCESS_LOADING_TIME = 30;
    private final String XPATH_GRANT_ACCESS_BUTTON = "//android.widget.Button[@content-desc = 'Grant access']";

    private final IButton grantAccessButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_GRANT_ACCESS_BUTTON), "Login Button");

    public void clickGrantAccessButton(){
        grantAccessButton.state().waitForDisplayed(Duration.ofSeconds(WAIT_ACCOUNT_ACCESS_LOADING_TIME));
        grantAccessButton.click();
    }






}
