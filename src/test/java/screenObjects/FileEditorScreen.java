package screenObjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import screenObjects.constants.ATTRIBUTE;

import java.time.Duration;

public class FileEditorScreen extends Screen {
    public FileEditorScreen(){
        super(By.xpath("//android.widget.Button[@content-desc = 'Undo']"), "File Editor Screen");
    }

    private final String ID_EDITOR_TEXT_BOX = "text";
    private final String XPATH_UNDO_BUTTON = "//android.widget.Button[@content-desc = 'Undo']";
    private final String XPATH_CLOSE_BUTTON = "//android.widget.Button[@content-desc = 'Close']";

    private final ITextBox editorTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_EDITOR_TEXT_BOX), "Editor text box");
    private final IButton undoButton = AqualityServices.getElementFactory().getButton(By.id(XPATH_UNDO_BUTTON), "Undo button");
    private final IButton closeButton = AqualityServices.getElementFactory().getButton(By.id(XPATH_CLOSE_BUTTON), "Close button");

    public void typeText(String text){
        editorTextBox.type(text);
    }
    public boolean isOpenedLessThen(int DurationOfSeconds){
        return this.state().waitForDisplayed(Duration.ofSeconds(DurationOfSeconds));
    }

    public void clickUndoButton(){
        undoButton.click();
    }
    public void clickCloseButton(){
        closeButton.click();
    }
    public String getText(){
        return  editorTextBox.getAttribute(ATTRIBUTE.TEXT);
    }

}
