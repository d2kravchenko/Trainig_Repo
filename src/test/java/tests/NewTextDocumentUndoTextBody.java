package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import tests.steps.NewTextDocumentUndoTextBodySteps;

public class NewTextDocumentUndoTextBody {

    @Test
    public void newTextDocumentUndoTextBodyTest(){
        AqualityServices.getLogger().info("Starting New Text Document Undo Text Body test");
        NewTextDocumentUndoTextBodySteps.addNewTextDocument();
        NewTextDocumentUndoTextBodySteps.typeNameAndSelectTemplate();
        NewTextDocumentUndoTextBodySteps.typeRandomTextUndoAndClose();
        NewTextDocumentUndoTextBodySteps.deleteFile();
        NewTextDocumentUndoTextBodySteps.refreshScreen();
    }
}

