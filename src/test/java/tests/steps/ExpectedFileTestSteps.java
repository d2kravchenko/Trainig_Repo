package tests.steps;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import screenObjects.FileEditorScreen;
import screenObjects.HomeScreen;
import tests.BaseTest;

public class ExpectedFileTestSteps extends BaseTest {

    private static HomeScreen homeScreen;
    private static FileEditorScreen fileEditorScreen;

    public static void checkExistingFileOnMainScreen() {
        AqualityServices.getLogger().info("1. Go to main screen. " +
                "Check that file with name \"%s\" is contained on main screen", EXPECTED_FILE_NAME);
        homeScreen = new HomeScreen();
        Assert.assertTrue(homeScreen.getFileForm(EXPECTED_FILE_NAME).isFileExist(), "File is not contained on main screen");
    }

    public static void openExistingFile() {
        AqualityServices.getLogger().info("2. Open file. " +
                "Check that text is \"%s\"", EXPECTED_FILE_TEXT);
        homeScreen.getFileForm(EXPECTED_FILE_NAME).openFile();
        fileEditorScreen = new FileEditorScreen();
        Assert.assertEquals(fileEditorScreen.getText(), EXPECTED_FILE_TEXT, "File text is different");
    }

    public static void closeFile() {
        AqualityServices.getLogger().info("3. Close file");
        fileEditorScreen.clickCloseButton();
    }
}

