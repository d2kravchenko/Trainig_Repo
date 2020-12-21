package screenobjects.loginscreenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ServerPreLoginScreen extends Screen {

    public ServerPreLoginScreen() { super(By.xpath("//android.widget.Button[@content-desc = 'Log in']"), "Pre Login  screen");  }

    private final String XPATH_LOGIN_BUTTON = "//android.widget.Button[@content-desc = 'Log in']";

    private final IButton loginButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_LOGIN_BUTTON), "Login Button");

    public void clickLoginButton(){
        loginButton.click();
    }






}
