package screenobjects.forms;
import models.ProjectModel;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;

public class PopularScreenItemForm extends Screen {

    public PopularScreenItemForm(int itemNumber) {
        super(By.xpath(String.format("//android.widget.RelativeLayout[@index = '%d']", itemNumber - 1 )), String.format("Item #%d on Popular tab", itemNumber)); //index begin from 0, the second element have index 1.
    }

    private final String ID_POPULAR_PROJECT_NAME = "name_and_blurb_text_view";
    private final String ID_POPULAR_PROJECT_PERCENT = "percent";
    private final String ID_POPULAR_PROJECT_DAYS = "deadline_countdown";
    private final String ID_POPULAR_PROJECT_TIME_UNITS = "deadline_countdown_unit";

    private final ILabel baseElementLabel = AqualityServices.getElementFactory().getLabel(this.getLocator(), "Base form label");
    private final ILabel popularProjectName = baseElementLabel.findChildElement(By.id(ID_POPULAR_PROJECT_NAME), "Popular project name", ILabel.class);
    private final ILabel popularProjectPercent = baseElementLabel.findChildElement(By.id(ID_POPULAR_PROJECT_PERCENT), "Popular Project percent label", ILabel.class);
    private final ILabel popularProjectDays = baseElementLabel.findChildElement(By.id(ID_POPULAR_PROJECT_DAYS), "Popular Project days label", ILabel.class);
    private final ILabel popularProjectTimeUnits = baseElementLabel.findChildElement(By.id(ID_POPULAR_PROJECT_TIME_UNITS), "Popular Project time units label", ILabel.class);

    public ProjectModel getProject2Data(){
        ProjectModel project = new ProjectModel();
        popularProjectTimeUnits.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        project.setName(popularProjectName.getAttribute(Attribute.TEXT.getValue()));
        project.setPercent(popularProjectPercent.getAttribute(Attribute.TEXT.getValue()));
        project.setDays(popularProjectDays.getAttribute(Attribute.TEXT.getValue()));
        project.setTimeUnits(popularProjectTimeUnits.getAttribute(Attribute.TEXT.getValue()));
        return project;
    }


}
