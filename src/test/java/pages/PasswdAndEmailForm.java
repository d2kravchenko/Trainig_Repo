package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PasswdAndEmailForm extends Form {

    public PasswdAndEmailForm() { super(By.xpath("//div[@class = 'login-form__container']"), "Login Form Container"); }

    private static final String XPATH_FIELD_PASSWORD = "//input[@placeholder = 'Choose Password']";

    private static final ITextBox PasswordBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_FIELD_PASSWORD), "Password textbox");

    public static boolean pageOpened(){ return PasswordBox.getElement().isDisplayed();  }

}
