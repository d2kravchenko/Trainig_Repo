package tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import tests.steps.ExpectedFileTestSteps;

public class ExpectedFileTest {

    @Test
    public void expectedFileTest(){
        AqualityServices.getLogger().info("Starting Expected File test");
        ExpectedFileTestSteps.checkExistingFileOnMainScreen();
        ExpectedFileTestSteps.openExistingFile();
        ExpectedFileTestSteps.closeFile();
    }
}

