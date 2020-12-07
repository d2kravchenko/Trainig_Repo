package screenObjects.forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class FileDeletingForm extends Screen {
    public FileDeletingForm(){
        super(By.xpath("//android.widget.Button[@text = 'Delete']"), "File Deleting Screen");
    }

    private final String XPATH_DELETE_BUTTON = "//android.widget.Button[@text = 'Delete']";

    private final IButton deleteButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_DELETE_BUTTON), "File Delete button");

    public void acceptDeletion(){
        deleteButton.click();
    }

}
