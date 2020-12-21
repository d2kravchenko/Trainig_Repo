package steps;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.ProjectModel;
import org.testng.Assert;
import screenobjects.ProjectScreen;
import screenobjects.SearchScreen;
import screenobjects.forms.MenuForm;
import screenobjects.forms.PopularScreenItemForm;
import utils.DateUtils;
import utils.SwipeUtils;

public class PopularProjectTestSteps {

    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private static final int POPULAR_ITEM_NUMBER_IN_LIST = (int) testData.getValue("/PopularItemNumberInList");

    private static ProjectModel oldProject = new ProjectModel();
    private static ProjectModel newProject = new ProjectModel();

    private static MenuForm menuForm;
    private static SearchScreen searchScreen;

    public static void swipeToPopularStep() {
        AqualityServices.getLogger().info("1. From main screen swipe to Popular screen. " +
                "Check that Popular tab is selected");
        SwipeUtils.swipeToRightTab();
        menuForm = new MenuForm();
        Assert.assertTrue(menuForm.isPopularSelected(), "Popular tab is not selected");
    }

    public static void getProjectFromPopularListStep() {
        AqualityServices.getLogger().info("2. Get name, funding percentage, number of days of the %d popular project from list", POPULAR_ITEM_NUMBER_IN_LIST);
        AqualityServices.getLogger().info("Getting data from Project #%d on Popular tab", POPULAR_ITEM_NUMBER_IN_LIST);
        oldProject = new PopularScreenItemForm(POPULAR_ITEM_NUMBER_IN_LIST).getProjectData();
    }

    public static void searchProjectStep() {
        AqualityServices.getLogger().info("3. Open search, enter the name of the project obtained previously. " +
                "Check that searching project was found and our Project has same percents and days on Search and Popular screens");
        AqualityServices.getLogger().debug(menuForm.isExist() ? "Menu form still displayed" : "Menu form is not exist");
        menuForm.clickSearchButton();
        searchScreen = new SearchScreen();
        searchScreen.search(oldProject.getName());
        newProject = searchScreen.getProjectData();
        Assert.assertTrue(searchScreen.projectFound(), "Project was not founded");
        Assert.assertEquals(newProject, oldProject, "Discount percents or days does not match");
    }

    public static void openFoundedProjectAndGetIt(){
        AqualityServices.getLogger().info("4. Open project, get funding date. " +
                "Check that the number of days before the funding date is the same");
        searchScreen.clickProject();
        int days = DateUtils.getDaysToDate(new ProjectScreen().getFundDate());
        Assert.assertEquals(Integer.parseInt(oldProject.getDays()), days, "The number of days from Popular screen does not match the number of days before the funding date");
    }
}

