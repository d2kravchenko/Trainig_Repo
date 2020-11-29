package ScreenObjects;
import Models.mProject;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class PopularScreen extends Screen {

    public PopularScreen() {
        super(By.xpath("//android.widget.TextView[@text = 'Popular']"), "Popular tab screen");
    }

    private final String XPATH_popularProject = "//android.widget.RelativeLayout[@index = '1']"; //2nd item from project list
    private final String XPATH_popularProjectName = XPATH_popularProject + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/name_and_blurb_text_view']";
    private final String XPATH_popularProjectPercent = XPATH_popularProject + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/percent']";
    private final String XPATH_popularProjectDays = XPATH_popularProject + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/deadline_countdown']";
    private final String XPATH_popularProjectTimeUnits = XPATH_popularProject + "//android.widget.TextView[@resource-id = 'com.kickstarter.kickstarter:id/deadline_countdown_unit']";

    private final ILabel popularProject = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_popularProject), "Popular Project 2");
    private final ILabel popularProjectName = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_popularProjectName), "Popular Project 2 name label");
    private final ILabel popularProjectPercent = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_popularProjectPercent), "Popular Project 2 percent label");
    private final ILabel popularProjectDays = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_popularProjectDays), "Popular Project 2 days label");
    private final ILabel popularProjectTimeUnits = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_popularProjectTimeUnits), "Popular Project 2 time units label");

    public mProject getProject_2_Data(){

        mProject mp = new mProject();

        popularProject.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        mp.setName(popularProjectName.getAttribute("text"));
        mp.setPercent(popularProjectPercent.getAttribute("text"));
        mp.setName(popularProjectDays.getAttribute("text"));
        mp.setTimeUnits(popularProjectTimeUnits.getAttribute("text"));
        return mp;
    }


}
