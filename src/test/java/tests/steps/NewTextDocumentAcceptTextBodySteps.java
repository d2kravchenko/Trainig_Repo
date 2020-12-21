package tests.steps;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import screenobjects.AddingFileScreen;
import screenobjects.FileEditorScreen;
import screenobjects.HomeScreen;
import tests.BaseTest;

public class NewTextDocumentAcceptTextBodySteps extends BaseTest {

    private static HomeScreen homeScreen;
    private static AddingFileScreen addingFileScreen;
    private static FileEditorScreen fileEditorScreen;

    public static void addNewTextDocument() {
        AqualityServices.getLogger().info("1. Go to main screen, click \"add file\" button and choose to create a text document");
        homeScreen = new HomeScreen();
        homeScreen.selectNewTestDocumentCreation();
    }

    public static void typeNameAndSelectTemplate() {
        AqualityServices.getLogger().info("2. Type a random file name and select an empty template. " +
                "Check that correct file name is displayed and the file editing screen is opened in less then 30 seconds");
        homeScreen.acceptNameAndEmptyFileTemplate(GENERATED_TEXT_DOCUMENT_NAME);
        addingFileScreen = new AddingFileScreen();
        Assert.assertEquals(addingFileScreen.getFilename(), GENERATED_TEXT_DOCUMENT_NAME, "Name is not correct");
        GENERATED_TEXT_DOCUMENT_NAME = addingFileScreen.getFilenameWithExtension(); //The filename must contains an extension in next usage
        fileEditorScreen = new FileEditorScreen();
        Assert.assertTrue(fileEditorScreen.isOpenedLessThen(TEXT_EDITOR_MAXIMUM_OPEN_DURATION), "File editing screen is not opened in less then 30 seconds");
    }

    public static void typeRandomTextAndClose() {
        AqualityServices.getLogger().info("3. Enter random text, close file. " +
                "Check that the created file is present in the file list");
        fileEditorScreen.typeText(GENERATED_TEXT_DOCUMENT_BODY);
        fileEditorScreen.clickCloseButton();
        AqualityServices.getLogger().info(homeScreen.isOpened() ? "Returned to Home screen" : "Home screen not opened");
        Assert.assertTrue(homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).isFileExist(), "Created file is not present in the file list");
    }

    public static void deleteFile() {
        AqualityServices.getLogger().info("4. Delete file");
        homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).deleteFile();
    }
}

