import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.ItemModel;
import models.SellerModel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import screenobjects.HomeScreen;
import screenobjects.ItemScreen;
import screenobjects.SelectCityScreen;
import screenobjects.SellerScreen;
import utils.Alerts;

public class SecretClosetTest {

    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private final String CITY_NAME = testData.getValue("/CityName").toString();

    @AfterTest
    public void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }

    @Test
    public void secretClosetTest() {
        AqualityServices.getLogger().info("Starting SecretCloset test");

        AqualityServices.getLogger().info("1. Click on city label");
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.clickCityLabel();

        AqualityServices.getLogger().info("2, 3. Type %s in search field, click on search result", CITY_NAME);
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        Alerts.ifAlertThenAccept();
        selectCityScreen.searchAndSelectCity(CITY_NAME);
        AqualityServices.getLogger().debug(homeScreen.isOpened() ? "Home screen opened" : "Home screen not opened");

        AqualityServices.getLogger().info("4. Check that city \"%s\" is selected as Region", CITY_NAME);
        Assert.assertTrue(homeScreen.isCityNameCorrect(CITY_NAME), String.format("City \"%s\" is not selected (names do not match)", CITY_NAME));
        ItemModel firstItem = homeScreen.getFirstItem();

        AqualityServices.getLogger().info("5. Select first item with discount");
        homeScreen.selectFirstItem();
        ItemScreen itemScreen = new ItemScreen();
        ItemModel selectedItem = itemScreen.parseItemData();

        AqualityServices.getLogger().info("6, 7. Check that selected item is displaying, check that old price, discount and price with discount are correct");
        Assert.assertEquals(firstItem, selectedItem, "Items data do not match");
        SellerModel itemScreenSeller = itemScreen.parseSellerData();

        AqualityServices.getLogger().info("8. Click on seller");
        itemScreen.selectSeller();
        SellerScreen sellerScreen = new SellerScreen();

        AqualityServices.getLogger().info("9. Check that seller information is correct (name, city)");
        Assert.assertTrue(sellerScreen.isSellerDataCorrect(itemScreenSeller), "Sellers data do not match");
    }
}

