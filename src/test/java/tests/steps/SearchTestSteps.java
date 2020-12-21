package tests.steps;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import screenobjects.HomeScreen;
import tests.BaseTest;
import utils.ScriptHelper;

public class SearchTestSteps extends BaseTest {

    private static HomeScreen homeScreen;

    public static void searchFile(){
        AqualityServices.getLogger().info("1. Go to main screen. Search the file name \"%s\"." +
                              "Check that there is \"%s\" in the search results", EXPECTED_FILE_NAME, EXPECTED_FILE_NAME );
        homeScreen = new HomeScreen();
        homeScreen.searchFile(EXPECTED_FILE_NAME);
        ScriptHelper.acceptFormWithScript();
        Assert.assertTrue(homeScreen.getFileForm(EXPECTED_FILE_NAME).isFileExist(), "File not found in search results");
    }
}
