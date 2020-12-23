package tests.steps;

import pages.HomePage;
import pages.PasswdAndEmailForm;
import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.forms.TimerForm;
import tests.BaseTest;

public class TimerBeginFromZeroTestSteps extends BaseTest {

    private static final String EXPECTED_TIMER_VALUE = "11:11:11"; //This test must fail, timer start from 00:00:00

    @Step(value = "Open homepage. Check that page is opened.")
    public static void goToHomepage() {
        AqualityServices.getBrowser().goTo(HOMEPAGE);
        AqualityServices.getBrowser().waitForPageToLoad();
        Assert.assertTrue(HomePage.pageOpened(), "<Home page not opened>");
        HomePage.clickStartButton();
        AqualityServices.getBrowser().waitForPageToLoad();
        Assert.assertTrue(PasswdAndEmailForm.pageOpened(), "<Page not opened>");
    }

    @Step(value = "Check that timer starts from zero.")
    public static void checkCounter() {
        Assert.assertEquals(TimerForm.getTimerValue(), EXPECTED_TIMER_VALUE, String.format("<Timer start not from %s>", EXPECTED_TIMER_VALUE));
    }
}