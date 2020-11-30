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

    private final int startIndexOfDateStringCut = 31; // String example -> This project will be funded on |->Dec 31, 2020 2:41 PM.
    private final int endIndexOfDateStringCut = -3;   // String example -> This project will be funded on Dec 31, 2020 2:41<-| PM.
    private final String defaultDate = "Jan 01, 1900 0:00";
    private final String XPATH_FundDate = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_disclaimer_text_view']";
    private final String XPATH_isFunded = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_state_header_text_view']";

    private final ILabel fundDateLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_FundDate), "Found Date Label");
    private final ILabel isFundedLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_isFunded), "Project Founded Label");

    public String getFundDate(){
        fundDateLabel.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        String date = defaultDate;
        if (fundDateLabel.state().isExist()) {
            date = fundDateLabel.getAttribute("text");
            date = date.substring(startIndexOfDateStringCut, date.length() + endIndexOfDateStringCut);
        } else if (isFundedLabel.state().isExist()) {                         //Project can be in "Funded" state
            AqualityServices.getLogger().warn("Project already funded.");
        }
        return date;

    }



}
