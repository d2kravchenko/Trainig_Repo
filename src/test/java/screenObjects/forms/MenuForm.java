package screenObjects.forms;

import screenObjects.ATTRIBUTE;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MenuForm extends Screen {

    public MenuForm() {
        super(By.id("discovery_tab_layout"), "Menu");
    }

    private final String XPATH_POPULAR_BUTTON = "//android.widget.TextView[@text = 'Popular']";
    private final String XPATH_SEARCH_BUTTON = "//android.widget.ImageButton[@resource-id = 'com.kickstarter.kickstarter:id/search_button']";

    private final IButton popularButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_POPULAR_BUTTON), "Popular tab button");
    private final IButton searchButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_SEARCH_BUTTON), "Search button");

    public boolean isPopularSelected(){
        return popularButton.getAttribute(ATTRIBUTE.SELECTED).equals("true");
    }

    public void clickSearchButton(){
        searchButton.getTouchActions().scrollToElement(SwipeDirection.UP);
        searchButton.click();
    }
    public boolean isExist(){
        return this.state().waitForExist();
    }
}
