package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class HelpForm extends Form {

    public HelpForm(){  super(By.xpath("//div[@class = 'help-form']"), "Help Form"); }

    /*Xpath*/

    private final String XPATH_BUTTON_SendToBottom = "//button[@class = 'button button--solid button--blue help-form__send-to-bottom-button']";

    /*Elements*/

    private final IButton SendToBottomButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_SendToBottom), "SendToBottom Button");

    /*Methods*/

    public void hideHelpForm(){
        if (isHelpFormExists()) {
            SendToBottomButton.click();
        }
    }

    public boolean isHelpFormExists(){
return this.getFormLabel().state().isDisplayed();
    }


}
