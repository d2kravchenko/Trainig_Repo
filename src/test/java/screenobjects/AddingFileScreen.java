package screenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;

public class AddingFileScreen  extends Screen {

    public AddingFileScreen(){
        super(By.id("progressBar2"), "Adding file screen");
    }

    private final String ID_FILE_NAME = "filename";

    private final ILabel filenameLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_FILE_NAME), "Filename Label");

    public String getFilename(){
          this.state().waitForDisplayed();
          String fileName = filenameLabel.getAttribute(Attribute.TEXT.getValue());
          return fileName.substring(0, fileName.lastIndexOf("."));
    }
        public String getFilenameWithExtension(){
          this.state().waitForDisplayed();
          return filenameLabel.getAttribute(Attribute.TEXT.getValue());
    }


}
