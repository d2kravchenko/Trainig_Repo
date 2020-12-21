import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import steps.PopularProjectTestSteps;

public class PopularProjectTest {

    @AfterTest
    public static void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }

    @Test
    public void popularProjectTest(){
        AqualityServices.getLogger().info("Starting Popular Project Test");
        PopularProjectTestSteps.swipeToPopularStep();
        PopularProjectTestSteps.getProjectFromPopularListStep();
        PopularProjectTestSteps.searchProjectStep();
        PopularProjectTestSteps.openFoundedProjectAndGetIt();
    }
}

