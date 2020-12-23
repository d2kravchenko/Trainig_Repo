package pages;

import models.User;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PasswdAndEmailForm extends Form {

    public PasswdAndEmailForm() { super(By.xpath("//div[@class = 'login-form__container']"), "Login Form Container"); }

    /*Xpath*/
    private static final String XPATH_FIELD_PASSWORD = "//input[@placeholder = 'Choose Password']";
    private static final String XPATH_FIELD_EMAIL_NAME = "//input[@placeholder = 'Your email']";
    private static final String XPATH_FIELD_EMAIL_DOMAIN = "//input[@placeholder = 'Domain']";
    private static final String XPATH_TopLevelDomain_LIST = "//div[@class = 'dropdown__field']";
    private static final String XPATH_TopLevelDomain_BUTTON = "//div[@class = 'dropdown__list']/div[2]";
    private static final String XPATH_CHECKBOX_TERMS = "//span[@class = 'checkbox__box']";
    private static final String XPATH_BUTTON_NEXT = "//a[@class = 'button--secondary']";

    /*Elements*/
    private static final ITextBox PasswordBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_FIELD_PASSWORD), "Password textbox");
    private static final ITextBox EmailNameBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_FIELD_EMAIL_NAME), "Email name textbox");
    private static final ITextBox EmailDomainBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_FIELD_EMAIL_DOMAIN), "Email domain textbox");
    private static final IButton TopLevelDomainListButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_TopLevelDomain_LIST), "Dropdown list");
    private static final IButton TopLevelDomainButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_TopLevelDomain_BUTTON), "Top Level Domain Button");
    private static final ICheckBox TermsCheckbox = AqualityServices.getElementFactory().getCheckBox(By.xpath(XPATH_CHECKBOX_TERMS), "Terms and Conditions Checkbox");
    private static final IButton NextButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_NEXT), "Next button");



    /*Methods*/

    public static void enterPassword(String password){ PasswordBox.clearAndType(password);  }
    public static void enterEmailName(String emailName){ EmailNameBox.clearAndType(emailName);  }
    public static void enterEmailDomain(String emailDomain){ EmailDomainBox.clearAndType(emailDomain);  }
    public static void acceptTermsAndConditions(){ TermsCheckbox.click();  }
    public static void selectTopLevelDomain(){
        TopLevelDomainListButton.click();
        TopLevelDomainButton.click();
    }

    public static void clickNextButton(){ NextButton.click(); }

    public static boolean pageOpened(){ return PasswordBox.getElement().isDisplayed();  }

    public static void acceptWithData(User user) {

        enterPassword(user.getPassword());
        enterEmailName(user.getEmailName());
        enterEmailDomain(user.getEmailDomain());
        selectTopLevelDomain();
        acceptTermsAndConditions();
        clickNextButton();
    }
}
