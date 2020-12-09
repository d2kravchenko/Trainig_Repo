package screenObjects;
import models.ProjectModel;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class PopularScreen extends Screen {

    public PopularScreen() {
        super(By.xpath("//android.widget.TextView[@text = 'Popular']"), "Popular tab screen");
    }

    private final String XPATH_POPULAR_PROJECT_BODY = "//android.widget.RelativeLayout[@index = '1']"; //2nd item from project list
    private final String XPATH_POPULAR_PROJECT_NAME = XPATH_POPULAR_PROJECT_BODY + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/name_and_blurb_text_view']";
    private final String XPATH_POPULAR_PROJECT_PERCENT = XPATH_POPULAR_PROJECT_BODY + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/percent']";
    private final String XPATH_POPULAR_PROJECT_DAYS = XPATH_POPULAR_PROJECT_BODY + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/deadline_countdown']";
    private final String XPATH_POPULAR_PROJECT_TIME_UNITS = XPATH_POPULAR_PROJECT_BODY + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/deadline_countdown_unit']";

    private final ILabel popularProjectName = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_POPULAR_PROJECT_NAME), "Popular Project 2 name label");
    private final ILabel popularProjectPercent = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_POPULAR_PROJECT_PERCENT), "Popular Project 2 percent label");
    private final ILabel popularProjectDays = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_POPULAR_PROJECT_DAYS), "Popular Project 2 days label");
    private final ILabel popularProjectTimeUnits = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_POPULAR_PROJECT_TIME_UNITS), "Popular Project 2 time units label");

    public ProjectModel getProject2Data(){
        ProjectModel project = new ProjectModel();
        popularProjectTimeUnits.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        project.setName(popularProjectName.getAttribute(ATTRIBUTE.TEXT));
        project.setPercent(popularProjectPercent.getAttribute(ATTRIBUTE.TEXT));
        project.setDays(popularProjectDays.getAttribute(ATTRIBUTE.TEXT));
        project.setTimeUnits(popularProjectTimeUnits.getAttribute(ATTRIBUTE.TEXT));
        return project;
    }


}
