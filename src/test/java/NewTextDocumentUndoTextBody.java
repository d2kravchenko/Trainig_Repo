import screenObjects.AddingFileScreen;
import screenObjects.FileEditorScreen;
import screenObjects.HomeScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SwipeHelper;

public class NewTextDocumentUndoTextBody extends BaseTest {

    @Test
    public void newTextDocumentUndoTextBodyTest(){
        AqualityServices.getLogger().info("Starting New Text Document Undo Text Body test");

        AqualityServices.getLogger().info("1. Go to main screen, click \"add file\" button and choose to create a  text document");
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.selectNewTestDocumentCreation();

        AqualityServices.getLogger().info("2. Enter a random file name and choose an empty template");
        homeScreen.acceptNameAndEmptyFileTemplate(GENERATED_TEXT_DOCUMENT_NAME);
        AddingFileScreen addingFileScreen = new AddingFileScreen();
        AqualityServices.getLogger().info("Asserting that correct file name is displayed");
        Assert.assertEquals(addingFileScreen.getFilename(), GENERATED_TEXT_DOCUMENT_NAME, "Name is not correct");
        GENERATED_TEXT_DOCUMENT_NAME = addingFileScreen.getFilenameWithExtension();
        FileEditorScreen fileEditorScreen = new FileEditorScreen();
        AqualityServices.getLogger().info("Asserting that the file editing screen is opened in less then 30 seconds");
        Assert.assertTrue(fileEditorScreen.isOpenedLessThen(TEXT_EDITOR_MAXIMUM_OPEN_DURATION), "File editing screen is not opened in less then 30 seconds");

        AqualityServices.getLogger().info("3. Enter random text, click Undo button, close file");
        fileEditorScreen.typeText(GENERATED_TEXT_DOCUMENT_BODY);
        fileEditorScreen.clickUndoButton();
        fileEditorScreen.clickCloseButton();
        AqualityServices.getLogger().info(homeScreen.isOpened() ? "Returned to Home screen" : "Home screen not opened");
        AqualityServices.getLogger().info("Asserting that the created file is present in the file list");
        Assert.assertTrue(homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).isFileExist(), "Created file is not present in the file list");

        AqualityServices.getLogger().info("4. Delete file");
        homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).deleteFile();
        AqualityServices.getLogger().info("Asserting that file is not present in the file list");
        Assert.assertTrue(homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).isFileNotExist(), "File is still present in file list");

        AqualityServices.getLogger().info("5. Refresh screen with gesture");
        SwipeHelper.swipeRefresh();
        AqualityServices.getLogger().info("Asserting that file is not present in the file list");
        Assert.assertTrue(homeScreen.getFileForm(GENERATED_TEXT_DOCUMENT_NAME).isFileNotExist(), "File is still present in file list");
    }
}

