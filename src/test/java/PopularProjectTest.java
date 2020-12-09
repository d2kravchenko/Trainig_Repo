import screenObjects.forms.MenuForm;
import models.ProjectModel;
import screenObjects.PopularScreen;
import screenObjects.ProjectScreen;
import screenObjects.SearchScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.DateUtils;
import utils.SwipeUtils;

public class PopularProjectTest {

    private ProjectModel oldProject = new ProjectModel();
    private ProjectModel newProject = new ProjectModel();

    @AfterTest
    public static void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }

    @Test
    public void popularProjectTest(){
        AqualityServices.getLogger().info("Starting Popular Project Test");

        AqualityServices.getLogger().info("1. From main screen swipe to Popular screen");
        MenuForm menuForm = new MenuForm();
        SwipeUtils.swipeToRightTab();
        AqualityServices.getLogger().info("Asserting that Popular tab is selected");
        Assert.assertTrue(menuForm.isPopularSelected(), "Popular tab not selected" );

        AqualityServices.getLogger().info("2. Get name, funding percentage, number of days of the second popular project from list");
        AqualityServices.getLogger().info("Getting data from Project#2 on Popular tab");
        oldProject = new PopularScreen().getProject2Data();

        AqualityServices.getLogger().info("3. Open search, enter the name of the project obtained previously");
        AqualityServices.getLogger().debug(menuForm.isExist() ? "Menu form still displayed" : "Menu form is not exist");
        menuForm.clickSearchButton();
        SearchScreen searchScreen = new SearchScreen();
        searchScreen.search(oldProject.getName());
        newProject = searchScreen.getProjectData();
        AqualityServices.getLogger().info("Asserting that searching project was found");
        Assert.assertTrue(searchScreen.projectFound(), "Project not founded" );
        AqualityServices.getLogger().info("Asserting that our Project has same percents and days on Search and Popular screens");
        Assert.assertEquals(newProject, oldProject, "Projects data does not match" );

        AqualityServices.getLogger().info("4. Open project, get funding date");
        searchScreen.clickProject();
        int Days = DateUtils.getDaysToDate(new ProjectScreen().getFundDate());
        AqualityServices.getLogger().info("Asserting that the number of days before the funding date is the same ");
        Assert.assertEquals(Integer.parseInt(oldProject.getDays()), Days, "The number of days from Popular screen does not match the number of days before the funding date");
    }
}

