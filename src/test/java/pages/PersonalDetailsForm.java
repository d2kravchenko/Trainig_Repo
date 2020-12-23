package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    public PersonalDetailsForm() { super(By.xpath("//div[@class = 'personal-details__form']"), "Personal Details Form"); }

    /*Xpath*/

    private static final String XPATH_FIELD_FIRST_NAME = "//input[@placeholder = 'Placeholder...']";

    /*Elements*/

    private static final ITextBox FirstNameField = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_FIELD_FIRST_NAME), "Password textbox");


    /*Methods*/

    public static boolean pageOpened(){ return FirstNameField.getElement().isDisplayed();  }


}
