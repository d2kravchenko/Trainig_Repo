package screenobjects.loginscreenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginScreen extends Screen {

    public LoginScreen() { super(By.id("login"), "Login  screen");  }

    private final int WAIT_FOR_DISPLAYED_LOGIN_SCREEN = 2;
    private final String ID_LOGIN_BUTTON = "login";

    private final IButton loginButton = AqualityServices.getElementFactory().getButton(By.id(ID_LOGIN_BUTTON), "Login Button");

    public void clickLoginButton(){
        loginButton.click();
    }
    public boolean isLoginScreenDisplayed(){
        return this.state().waitForDisplayed(Duration.ofSeconds(WAIT_FOR_DISPLAYED_LOGIN_SCREEN));
    }




}
