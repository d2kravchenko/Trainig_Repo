package screenobjects.forms;

import screenobjects.Attribute;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MenuForm extends Screen {

    public MenuForm() {
        super(By.id("Magic"), "Menu");
    }

    private final String STRING_TRUE = "true";
    private final String XPATH_POPULAR_BUTTON = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Popular']";
    private final String ID_SEARCH_BUTTON = "search_button";

    private final IButton popularButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_POPULAR_BUTTON), "Popular tab button");
    private final IButton searchButton = AqualityServices.getElementFactory().getButton(By.id(ID_SEARCH_BUTTON), "Search button");

    public boolean isPopularSelected(){
        return popularButton.getAttribute(Attribute.SELECTED.getValue()).equals(STRING_TRUE);
    }

    public void clickSearchButton(){
        searchButton.getTouchActions().scrollToElement(SwipeDirection.UP);
        searchButton.click();
    }
    public boolean isExist(){
        return this.state().waitForExist();
    }
}
