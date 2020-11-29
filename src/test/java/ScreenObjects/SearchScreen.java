package ScreenObjects;
import Models.mProject;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SearchScreen extends Screen {

    public SearchScreen() {
        super(By.xpath("//android.view.ViewGroup[@resource-id = 'com.kickstarter.kickstarter:id/search_toolbar']"), "Search screen");

    }

    private final String XPATH_SearchTextBox = "//android.widget.EditText[@resource-id = 'com.kickstarter.kickstarter:id/search_edit_text']";
    private final String XPATH_Project = "//android.widget.LinearLayout[@resource-id = 'com.kickstarter.kickstarter:id/featured_search_result_view']";
    private final String ID_ProjectName = "project_name_text_view";
    private final String ID_ProjectPercent = "search_result_percent_funded_text_view";
    private final String ID_ProjectDays = "search_result_deadline_countdown_text_view";
    private final String ID_ProjectTimeUnits = "search_result_deadline_unit_text_view";

    private final ITextBox searchTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(XPATH_SearchTextBox), "Search text box");
    private final ILabel project = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_Project), "Project");
    private final ILabel projectName = AqualityServices.getElementFactory().getLabel(By.id(ID_ProjectName), "Project name label");
    private final ILabel projectPercent = AqualityServices.getElementFactory().getLabel(By.id(ID_ProjectPercent), "Project percent label");
    private final ILabel projectDays = AqualityServices.getElementFactory().getLabel(By.id(ID_ProjectDays), "Project days label");
    private final ILabel projectTimeUnits = AqualityServices.getElementFactory().getLabel(By.id(ID_ProjectTimeUnits), "Project time units label");

    public mProject getProjectData(){

        mProject mp = new mProject();
        mp.setName(projectName.getAttribute("text"));
        mp.setPercent(projectPercent.getAttribute("text"));
        mp.setDays(projectDays.getAttribute("text"));
        mp.setTimeUnits(projectTimeUnits.getAttribute("text"));
        return mp;
    }

    public void search(String key){
        int endIndex = key.indexOf(" ", 15);
        searchTextBox.clearAndType(key.substring(0, endIndex));  // Full name on popular page is longer then on search page, searching by part of name with space on end

    }
    public boolean projectFound(){
        return project.state().waitForDisplayed();
    }
    public void clickProject(){
        project.click();
    }

}
