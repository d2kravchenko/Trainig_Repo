package screenobjects.loginscreenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ServerLoginScreen extends Screen {

    public ServerLoginScreen() { super(By.xpath("//android.widget.EditText[@content-desc = 'Username or email']"), "Login screen");  }

    private final String XPATH_EMAIL_TEXT_BOX = "//android.widget.EditText[@content-desc = 'Username or email']";
    private final String XPATH_PASSWORD_TEXT_BOX = "//android.widget.EditText[@password = 'true']";
    private final String XPATH_LOGIN_BUTTON = "//android.widget.Button[@content-desc = 'Log in']";

    private final ITextBox emailTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_EMAIL_TEXT_BOX), "Login text box");
    private final ITextBox passwordTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_PASSWORD_TEXT_BOX), "Password text box");
    private final IButton loginButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_LOGIN_BUTTON), "Login Button");

    public void submitEmailAndPassword(String email, String password){
        emailTextBox.type(email);
        passwordTextBox.type(password);
        emailTextBox.click();                   // Without this action text in emailTextBox disappears after clicking loginButton for some reason
        loginButton.click();
    }






}
