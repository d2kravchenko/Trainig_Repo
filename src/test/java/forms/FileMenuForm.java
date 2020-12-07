package forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class FileMenuForm extends Screen {

    public FileMenuForm(){
        super(By.xpath("//android.widget.TextView[@text = 'Edit']"), "File menu");
    }

    private final String XPATH_DELETE_BUTTON = "//android.widget.TextView[@text = 'Delete']";

    private final IButton deleteButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_DELETE_BUTTON), "Delete button");

    public void clickDeleteButton(){
        deleteButton.click();
    }

    




}
