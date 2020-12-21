package screenobjects.loginscreenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ServerAddressScreen extends Screen {

    public ServerAddressScreen() { super(By.id("host_url_input"), "Server address screen");  }

    private final String ID_SERVER_ADDRESS_TEXT_BOX = "host_url_input";
    private final String ID_SUBMIT_SERVER_BUTTON = "test_server_button";

    private final ITextBox serverAddressTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_SERVER_ADDRESS_TEXT_BOX), "Server address text box");
    private final IButton submitServerButton = AqualityServices.getElementFactory().getButton(By.id(ID_SUBMIT_SERVER_BUTTON), "Submit server button");

    public void EnterAndSubmitServerAddress(String address){
        serverAddressTextBox.clearAndType(address);
        submitServerButton.click();
    }






}
