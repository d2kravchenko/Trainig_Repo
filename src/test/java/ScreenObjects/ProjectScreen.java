package screenObjects;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ProjectScreen extends Screen {

    public ProjectScreen() {
        super(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.kickstarter.kickstarter:id/project_recycler_view']"), "Project screen");
    }
    private final int DATE_STRING_CUT_START_INDEX = 31; // String example -> This project will be funded on |->Dec 31, 2020 2:41 PM.
    private final int DATE_STRING_CUT_END_INDEX = -3;   // String example -> This project will be funded on Dec 31, 2020 2:41<-| PM.
    private final String DATE_DEFAULT = "Jan 01, 1900 0:00";
    private final String XPATH_FUND_DATE_LABEL = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_disclaimer_text_view']";
    private final String XPATH_IS_FUNDED_LABEL = "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/project_state_header_text_view']";

    private final ILabel fundDateLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_FUND_DATE_LABEL), "Fund Date Label");
    private final ILabel isFundedLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_IS_FUNDED_LABEL), "Project Funded Label");

    public String getFundDate(){
        fundDateLabel.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        String fundDate = DATE_DEFAULT;
        if (fundDateLabel.state().isExist()) {
            fundDate = fundDateLabel.getAttribute(ATTRIBUTE.TEXT);
            fundDate = fundDate.substring(DATE_STRING_CUT_START_INDEX, fundDate.length() + DATE_STRING_CUT_END_INDEX);
        } else if (isFundedLabel.state().isExist()) {                         //Project can be in "Funded" state
            AqualityServices.getLogger().warn("Project already funded.");
        }
        return fundDate;

    }



}
