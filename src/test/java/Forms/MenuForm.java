package Forms;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MenuForm extends Screen {

    public MenuForm() {
        super(By.id("discovery_tab_layout"), "Menu");
    }

    private final String XPATH_popularButton = "//android.widget.TextView[@text = 'Popular']";
    private final String XPATH_searchButton = "//android.widget.ImageButton[@resource-id = 'com.kickstarter.kickstarter:id/search_button']";

    private final IButton popularButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_popularButton), "Popular tab button");
    private final IButton searchButton = AqualityServices.getElementFactory().getButton(By.xpath(XPATH_searchButton), "Search button");

    public boolean isPopularSelected(){
        return popularButton.getAttribute("selected").equals("true");
    }

    public void clickSearchButton(){
        searchButton.getTouchActions().scrollToElement(SwipeDirection.UP);
        searchButton.click();
    }
}
