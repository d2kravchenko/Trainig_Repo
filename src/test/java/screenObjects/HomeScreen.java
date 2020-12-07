package screenObjects;

import screenObjects.forms.AddFileForm;
import screenObjects.forms.FileForm;
import screenObjects.forms.SelectNameAndTemplateForm;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import java.time.Duration;

public class HomeScreen extends Screen {
    public HomeScreen() { super(By.id("sort_list_button_group"), "Home  screen");  }

    private final int WAIT_FOR_CLICKABLE_ADD_FILE_BUTTON = 30;
    private final String ID_ADD_FILE_BUTTON = "fab_main";
    private final String ID_SEARCH_TEXT_BOX = "search_src_text";
    private final String ID_SEARCH_TEXT_BOX_LABEL = "search_text";

    private final IButton addFileButton = AqualityServices.getElementFactory().getButton(By.id(ID_ADD_FILE_BUTTON), "Add File Button");
    private final ILabel searchLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_SEARCH_TEXT_BOX_LABEL), "Search label");
    private final ITextBox searchTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_SEARCH_TEXT_BOX), "Search text box");

    private AddFileForm getAddFileForm(){
        return new AddFileForm();
    }
    private SelectNameAndTemplateForm getSelectNameAndTemplateForm(){
        return new SelectNameAndTemplateForm();
    }

    public FileForm getFileForm(String filename){
        return new FileForm(filename);
    }

    public void selectNewTestDocumentCreation(){
        addFileButton.state().waitForClickable(Duration.ofSeconds(WAIT_FOR_CLICKABLE_ADD_FILE_BUTTON));
        addFileButton.click();
        getAddFileForm().clickCreateNewTextDocumentButton();
    }
    public void acceptNameAndEmptyFileTemplate(String name){
        getSelectNameAndTemplateForm().acceptEmptyFileDocument(name);
    }
    public void searchFile(String filename){
        searchLabel.click();
        searchTextBox.type(filename);
    }
    public boolean isOpened(){
        return this.state().waitForDisplayed();
    }
}