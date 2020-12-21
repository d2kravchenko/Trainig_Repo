package tests.steps;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.ItemModel;
import models.SellerModel;
import org.testng.Assert;
import screenobjects.HomeScreen;
import screenobjects.ItemScreen;
import screenobjects.SelectCityScreen;
import screenobjects.SellerScreen;
import utils.Alerts;

public class SecretClosetTestSteps {

    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private static final String CITY_NAME = testData.getValue("/CityName").toString();

    private static HomeScreen homeScreen;
    private static SelectCityScreen selectCityScreen;
    private static ItemScreen itemScreen;
    private static SellerScreen sellerScreen;
    private static ItemModel firstItem;
    private static ItemModel selectedItem;
    private static SellerModel itemScreenSeller;

    public static void selectRegion() {
        AqualityServices.getLogger().info("1. Click on city label, type %s in search field, click on search result", CITY_NAME);
        AqualityServices.getLogger().info("Check that city \"%s\" is selected as Region", CITY_NAME);
        homeScreen = new HomeScreen();
        homeScreen.clickCityLabel();
        selectCityScreen = new SelectCityScreen();
        Alerts.ifAlertThenAccept();
        selectCityScreen.searchAndSelectCity(CITY_NAME);
        AqualityServices.getLogger().debug(homeScreen.isOpened() ? "Home screen opened" : "Home screen not opened");
        Assert.assertTrue(homeScreen.isCityNameCorrect(CITY_NAME), String.format("City \"%s\" is not selected (names do not match)", CITY_NAME));
        firstItem = homeScreen.getFirstItem();
    }

    public static void checkItemPrices() {
        AqualityServices.getLogger().info("2. Select first item with discount." +
                "Check that selected item is displaying, check that old price, discount and price with discount are correct");
        AqualityServices.getLogger().debug(homeScreen.isOpened() ? "Home screen is opened" : "Home screen is not opened");
        homeScreen.selectFirstItem();
        itemScreen = new ItemScreen();
        selectedItem = itemScreen.parseItemData();
        Assert.assertEquals(firstItem, selectedItem, "Items data do not match");
        itemScreenSeller = itemScreen.parseSellerData();
    }

    public static void checkSeller() {
        AqualityServices.getLogger().info("3. Click on seller." +
                "Check that seller information is correct (name, city)");
        itemScreen.selectSeller();
        sellerScreen = new SellerScreen();
        Assert.assertTrue(sellerScreen.isSellerDataCorrect(itemScreenSeller), "Sellers data do not match");
    }
}

