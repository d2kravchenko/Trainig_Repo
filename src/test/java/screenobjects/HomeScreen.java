package screenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ItemModel;
import org.openqa.selenium.By;
import screenobjects.forms.FirstBannerForm;

public class HomeScreen extends Screen {
    public HomeScreen() { super(By.id("tvTitle"), "Home  screen");  }

    private final String ID_CITY_BUTTON = "tvToolbarCity";
    private final String XPATH_DYNAMIC_CITY_NAME_LABEL = "//android.widget.TextView[@text = '%s']";

    private final ILabel cityLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_CITY_BUTTON), "City Label");

    private ILabel getCityNameLabel(String cityName){
        return AqualityServices.getElementFactory().getLabel(By.xpath(String.format(XPATH_DYNAMIC_CITY_NAME_LABEL, cityName)), String.format("City with name %s Label", cityName));
    }
    private FirstBannerForm getFirstBannerForm(){
        return new FirstBannerForm();
    }
    public void clickCityLabel(){
        cityLabel.click();
    }
    public boolean isCityNameCorrect(String cityName){
        return getCityNameLabel(cityName).state().waitForDisplayed(); // We need to wait until the name of the city is changed
    }
    public boolean isOpened(){
        return this.state().isExist();
    }
    public ItemModel getFirstItem(){
        return getFirstBannerForm().parseFirstItemData();
    }
    public void selectFirstItem(){
        getFirstBannerForm().selectItem();
    }




}