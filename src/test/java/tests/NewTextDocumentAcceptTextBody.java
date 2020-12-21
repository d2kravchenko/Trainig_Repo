package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import tests.steps.NewTextDocumentAcceptTextBodySteps;

public class NewTextDocumentAcceptTextBody {

    @Test
    public void newTextDocumentAcceptTextBodyTest(){
        AqualityServices.getLogger().info("Starting New Text Document Accept Text Body test");
        NewTextDocumentAcceptTextBodySteps.addNewTextDocument();
        NewTextDocumentAcceptTextBodySteps.typeNameAndSelectTemplate();
        NewTextDocumentAcceptTextBodySteps.typeRandomTextAndClose();
        NewTextDocumentAcceptTextBodySteps.deleteFile();
    }
}

