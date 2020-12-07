package forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class FileForm extends Screen {

    public FileForm(String filename){
        super(By.xpath(String.format("//android.widget.TextView[@text = '%s']" +
                "/ancestor::android.widget.LinearLayout[@resource-id = 'com.nextcloud.client:id/ListItemLayout']", filename)), "File with name " + filename );
    }

    private final String XPATH_FILE_MENU_BUTTON =  "//android.widget.ImageView[@resource-id = 'com.nextcloud.client:id/overflow_menu']";
    private final String XPATH_OPEN_FILE_BUTTON = "//android.widget.TextView[@resource-id = 'com.nextcloud.client:id/Filename']";

    private final FileMenuForm fileMenuForm = new FileMenuForm();
    private final FileDeletingForm fileDeletingForm = new FileDeletingForm();
    private final ILabel baseLabel = AqualityServices.getElementFactory().getLabel(this.getLocator(), "Base label");
    private final IButton fileMenuButton = baseLabel.findChildElement(By.xpath(XPATH_FILE_MENU_BUTTON), IButton.class);
    private final IButton openFileButton = baseLabel.findChildElement(By.xpath(XPATH_OPEN_FILE_BUTTON), IButton.class);

    public boolean isFileExist(){
        return this.state().waitForDisplayed();
    }
    public boolean isFileNotExist(){
        return this.state().waitForNotDisplayed();
    }
    public void deleteFile(){
        fileMenuButton.click();
        fileMenuForm.clickDeleteButton();
        fileDeletingForm.acceptDeletion();
    }
    public void openFile(){
        openFileButton.click();
    }





}
