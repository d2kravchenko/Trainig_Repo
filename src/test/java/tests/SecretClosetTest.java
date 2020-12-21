package tests;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tests.steps.SecretClosetTestSteps;

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
        SecretClosetTestSteps.selectRegion();
        SecretClosetTestSteps.checkItemPrices();
        SecretClosetTestSteps.checkSeller();
    }
}

