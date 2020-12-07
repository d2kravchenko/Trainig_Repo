package screenObjects.loginScreenObjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginScreen extends Screen {

    public LoginScreen() { super(By.id("login"), "Login  screen");  }

    private final String ID_LOGIN_BUTTON = "login";

    private final IButton loginButton = AqualityServices.getElementFactory().getButton(By.id(ID_LOGIN_BUTTON), "Login Button");

    public void clickLoginButton(){
        loginButton.click();
    }
    public boolean isLoginScreenDisplayed(){
        return this.state().waitForExist(Duration.ofSeconds(2));
    }




}
