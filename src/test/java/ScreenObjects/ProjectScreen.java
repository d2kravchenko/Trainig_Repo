package ScreenObjects;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ProjectScreen extends Screen {

    public ProjectScreen() {
        super(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.kickstarter.kickstarter:id/project_recycler_view']"), "Project screen");
    }

    private final String XPATH_FoundDate = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_disclaimer_text_view']";
    private final String XPATH_isFounded = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_state_header_text_view']";

    private final ILabel foundDateLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_FoundDate), "Found Date Label");
    private final ILabel isFoundedLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_isFounded), "Project Founded Label");

    public String getFoundDate(){
        foundDateLabel.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        String date = "Jan 01, 1900 0:00";
        if (foundDateLabel.state().isExist()) {
            date = foundDateLabel.getAttribute("text");
            date = date.substring(31, date.length()-3);
        } else if (isFoundedLabel.state().isExist()) {                         //Project can be in "Founded" state
            AqualityServices.getLogger().warn("Project already founded.");
        }
        return date;

    }



}
