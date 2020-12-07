package screenObjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class AddingFileScreen  extends Screen {

    public AddingFileScreen(){
        super(By.id("progressBar2"), "Adding file screen");
    }

    private final String ID_FILE_NAME = "filename";

    private final ILabel filenameLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_FILE_NAME), "Filename Label");

    public String getFilename(){
          this.state().waitForDisplayed();
          String fileName = filenameLabel.getAttribute(ATTRIBUTE.TEXT);
          return fileName.substring(0, fileName.lastIndexOf("."));
    }
        public String getFilenameWithExtension(){
          this.state().waitForDisplayed();
          return filenameLabel.getAttribute(ATTRIBUTE.TEXT);
    }


}
