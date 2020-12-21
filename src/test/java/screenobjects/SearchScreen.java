package screenobjects;
import models.ProjectModel;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;

public class SearchScreen extends Screen {

    public SearchScreen() {
        super(By.id("search_toolbar"), "Search screen");
    }

    private final int MAX_NAME_SIZE = 15;
    private final String ID_SEARCH_TEXT_BOX = "search_edit_text";
    private final String ID_PROJECT_LABEL = "featured_search_result_view";
    private final String ID_PROJECT_NAME = "project_name_text_view";
    private final String ID_PROJECT_PERCENT = "search_result_percent_funded_text_view";
    private final String ID_PROJECT_DAYS = "search_result_deadline_countdown_text_view";
    private final String ID_PROJECT_TIME_UNITS = "search_result_deadline_unit_text_view";

    private final ITextBox searchTextBox = AqualityServices.getElementFactory().getTextBox(By.id(ID_SEARCH_TEXT_BOX), "Search text box");
    private final ILabel projectLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_PROJECT_LABEL), "Project");
    private final ILabel projectName = AqualityServices.getElementFactory().getLabel(By.id(ID_PROJECT_NAME), "Project name label");
    private final ILabel projectPercent = AqualityServices.getElementFactory().getLabel(By.id(ID_PROJECT_PERCENT), "Project percent label");
    private final ILabel projectDays = AqualityServices.getElementFactory().getLabel(By.id(ID_PROJECT_DAYS), "Project days label");
    private final ILabel projectTimeUnits = AqualityServices.getElementFactory().getLabel(By.id(ID_PROJECT_TIME_UNITS), "Project time units label");

    public ProjectModel getProjectData(){
        ProjectModel project = new ProjectModel();
        project.setName(projectName.getAttribute(Attribute.TEXT.getValue()));
        project.setPercent(projectPercent.getAttribute(Attribute.TEXT.getValue()));
        project.setDays(projectDays.getAttribute(Attribute.TEXT.getValue()));
        project.setTimeUnits(projectTimeUnits.getAttribute(Attribute.TEXT.getValue()));
        return project;
    }

    public void search(String key){
        int endIndex = key.indexOf(" ", MAX_NAME_SIZE);
        searchTextBox.clearAndType(key.substring(0, endIndex));  // Full name on popular page is longer then on search page, searching by part of name with space on end
    }
    public boolean projectFound(){
        return projectLabel.state().waitForDisplayed();
    }
    public void clickProject(){
        projectLabel.click();
    }

}
