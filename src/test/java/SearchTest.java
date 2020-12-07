import screenObjects.HomeScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
        AqualityServices.getLogger().info("Starting Search test");

        AqualityServices.getLogger().info("1. Go to main screen");
        HomeScreen homeScreen = new HomeScreen();

        AqualityServices.getLogger().info("2. Search the file name \"%s\"", EXPECTED_FILE_NAME);
        homeScreen.searchFile(EXPECTED_FILE_NAME);
        Steps.acceptFormWithScript();
        AqualityServices.getLogger().info("Asserting that there is \"%s\" in the search results", EXPECTED_FILE_NAME);
        Assert.assertTrue(homeScreen.getFileForm(EXPECTED_FILE_NAME).isFileExist(), "File not found in search results");
    }
}

