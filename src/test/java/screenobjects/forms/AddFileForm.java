package screenobjects.forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class AddFileForm extends Screen {

    public AddFileForm() { super(By.id("add_to_cloud"), "Add File Form");  }

    private final String XPATH_CREATE_NEW_TEXT_DOCUMENT_BUTTON = "//android.widget.TextView[@text = 'Create new text document']";

    private final IButton createNewTextDocumentButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_CREATE_NEW_TEXT_DOCUMENT_BUTTON), "Create new text document button");

    public void clickCreateNewTextDocumentButton(){
        createNewTextDocumentButton.click();
    }

}
