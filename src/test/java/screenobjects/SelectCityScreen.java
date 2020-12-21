package screenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SelectCityScreen extends Screen {

    public SelectCityScreen(){
        super(By.id("rlToolbarSearch"), "Select City Screen");
    }

    private final String ID_SEARCH_TEXT_BOX = "etSearchTest";
    private final String ID_FOUNDED_CITY = "tvCityItemName";

    private final ITextBox searchTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_SEARCH_TEXT_BOX), "Search Text Box");
    private final ILabel foundedCity = AqualityServices.getElementFactory().getLabel(By.id(ID_FOUNDED_CITY), "Founded City");

    public void searchAndSelectCity(String city){
        searchTextBox.type(city);
        foundedCity.click();
    }
}
