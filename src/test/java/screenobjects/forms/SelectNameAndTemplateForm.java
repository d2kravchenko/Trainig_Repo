package screenobjects.forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SelectNameAndTemplateForm extends Screen {

    public SelectNameAndTemplateForm() { super(By.xpath("//android.widget.TextView[@text = 'Select template']"), "Select Name And Template Form");  }

    private final String ID_FILE_NAME_TEXT_BOX = "filename";
    private final String XPATH_EMPTY_FILE_TEMPLATE_BUTTON = "//android.widget.TextView[@text = 'Empty file']";

    private final ITextBox fileNameTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_FILE_NAME_TEXT_BOX), "File name text box");
    private final IButton emptyFileTemplateButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_EMPTY_FILE_TEMPLATE_BUTTON), "Empty file template button");

    public void acceptEmptyFileDocument(String name){
        fileNameTextBox.type(name);
        emptyFileTemplateButton.click();
    }

}
