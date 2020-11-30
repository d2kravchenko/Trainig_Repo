import Forms.MenuForm;
import Models.mProject;
import ScreenObjects.PopularScreen;
import ScreenObjects.ProjectScreen;
import ScreenObjects.SearchScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.DateUtils;
import utils.SwipeUtils;

public class MobileTest {

    private mProject oldProject = new mProject();
    private mProject newProject = new mProject();

    @AfterTest
    public static void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }

    @Test
    public void PopularProjectTest(){
        AqualityServices.getLogger().info("Starting Popular Project Test");
        MenuForm menuForm = new MenuForm();
        SwipeUtils.swipeToRightTab();
        AqualityServices.getLogger().info("Asserting that Popular tab is selected");
        Assert.assertTrue(menuForm.isPopularSelected(), "Popular tab not selected" );
        PopularScreen popularScreen = new PopularScreen();
        AqualityServices.getLogger().info("Getting data from Project#2 on Popular tab");
        oldProject = popularScreen.getProject_2_Data();
        menuForm.clickSearchButton();
        SearchScreen searchScreen = new SearchScreen();
        searchScreen.search(oldProject.getName());
        newProject = searchScreen.getProjectData();
        AqualityServices.getLogger().info("Asserting that searching project was found");
        Assert.assertTrue(searchScreen.projectFound(), "Project not founded" );
        AqualityServices.getLogger().info("Asserting that our Project has same percents and days on Search and Popular screens");
        Assert.assertEquals(newProject, oldProject, "Projects data does not match" );
        searchScreen.clickProject();
        ProjectScreen projectScreen = new ProjectScreen();
        int Days = DateUtils.getDaysToDate(projectScreen.getFundDate());
        AqualityServices.getLogger().info("Asserting that the number of days before the funding date is the same ");
        Assert.assertEquals(Integer.parseInt(oldProject.getDays()), Days, "The number of days from Popular screen does not match the number of days before the funding date");
    }
}

