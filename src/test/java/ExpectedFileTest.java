import screenObjects.FileEditorScreen;
import screenObjects.HomeScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedFileTest extends BaseTest {

    @Test
    public void expectedFileTest(){
        AqualityServices.getLogger().info("Starting Expected File test");

        AqualityServices.getLogger().info("1. Go to main screen");
        HomeScreen homeScreen = new HomeScreen();
        AqualityServices.getLogger().info("Assert that file with name \"%s\" is contained on main screen", EXPECTED_FILE_NAME);
        Assert.assertTrue(homeScreen.getFileForm(EXPECTED_FILE_NAME).isFileExist(), "File is not contained on main screen");

        AqualityServices.getLogger().info("2. Open file");
        homeScreen.getFileForm(EXPECTED_FILE_NAME).openFile();
        FileEditorScreen fileEditorScreen = new FileEditorScreen();
        AqualityServices.getLogger().info("Assert that text is \"%s\"", EXPECTED_FILE_TEXT);
        Assert.assertEquals(fileEditorScreen.getText(), EXPECTED_FILE_TEXT, "File text is different");

        AqualityServices.getLogger().info("3. Close file");
        fileEditorScreen.clickCloseButton();
    }
}

