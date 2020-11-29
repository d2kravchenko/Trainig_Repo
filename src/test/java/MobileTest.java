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
        MenuForm menuForm = new MenuForm();
        SwipeUtils.swipeToRightTab();
        Assert.assertTrue(menuForm.isPopularSelected());
        PopularScreen popularScreen = new PopularScreen();
        oldProject = popularScreen.getProject_2_Data();
        menuForm.clickSearchButton();
        SearchScreen searchScreen = new SearchScreen();
        searchScreen.search(oldProject.getName());
        newProject = searchScreen.getProjectData();
        Assert.assertTrue(searchScreen.projectFound());
        Assert.assertEquals(newProject, oldProject);
        searchScreen.clickProject();
        ProjectScreen projectScreen = new ProjectScreen();
        int Days = DateUtils.getSecondsToDate(projectScreen.getFoundDate());
        Assert.assertEquals(Integer.parseInt(oldProject.getDays()), Days);
    }
}

