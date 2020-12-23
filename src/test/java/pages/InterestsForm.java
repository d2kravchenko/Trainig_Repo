package pages;

import utils.*;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.generator.IntGenerator;

import java.io.File;

public class InterestsForm extends Form {



    public InterestsForm() { super(By.xpath("//div[@class = 'avatar-and-interests__form']"), "Avatar and Interests Form"); }

    /*Xpath*/

    private static final String XPATH_CHECKBOX_UNSELECT_ALL = "//label[@for = 'interest_unselectall']";
    private static final String XPATH_BUTTON_NEXT = "//button[contains(text(), 'Next')]";
    private static final String XPATH_BUTTON_UPLOAD = "//a[@class = 'avatar-and-interests__upload-button']";
    private static final String XPATH_INTEREST_LIST = "//div[@class = 'avatar-and-interests__interests-list']";


    /*Elements*/

    private static final ICheckBox UnselectAllCheckbox = AqualityServices.getElementFactory().getCheckBox(By.xpath(XPATH_CHECKBOX_UNSELECT_ALL), "Unselect All Checkbox");
    private static final IButton UploadButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_UPLOAD), "Next button");
    private static final IButton NextButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_BUTTON_NEXT), "Next button");


    /*Methods*/


    public static void unselectAll(){ UnselectAllCheckbox.click();  }

    public static void selectThreeRandomInterests() {

        int[] numArray = IntGenerator.getSpecificNumber();
        for (int i = 0; i<3; i++) {
            String ChildXpath = XPATH_INTEREST_LIST + "/div[" + numArray[i] + "]//span[@class = 'checkbox small']";
            ICheckBox interestCheckBox = AqualityServices.getElementFactory().getCheckBox(By.xpath(ChildXpath), "Interest[" + numArray[i] + "] CheckBox");
            interestCheckBox.click();
        }
    }

    public static boolean pageOpened(){ return NextButton.getElement().isDisplayed();  }

    public static void clickNextButton(){ NextButton.click(); }

    public static void uploadFile(File file) {
        UploadButton.click();
        Paths.copyFilePathToClipboard(file);
        RobotScenario.pasteAndEnter();
    }



}
