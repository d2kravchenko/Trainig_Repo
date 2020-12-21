package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import tests.steps.SearchTestSteps;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
        AqualityServices.getLogger().info("Starting Search test");
        SearchTestSteps.searchFile();
    }
}

