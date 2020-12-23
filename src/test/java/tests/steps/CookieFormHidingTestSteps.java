package tests.steps;

import pages.CookieForm;
import pages.HomePage;
import pages.PasswdAndEmailForm;
import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import tests.BaseTest;

public class CookieFormHidingTestSteps extends BaseTest {

    private static final CookieForm cookieForm = new CookieForm();

    @Step(value = "Open homepage. Check that page is opened.")
    public static void goToHomepage() {
        AqualityServices.getBrowser().goTo(HOMEPAGE);
        AqualityServices.getBrowser().waitForPageToLoad();
        Assert.assertTrue(HomePage.pageOpened(), "<Home page not opened>");
        HomePage.clickStartButton();
        AqualityServices.getBrowser().waitForPageToLoad();
        Assert.assertTrue(PasswdAndEmailForm.pageOpened(), "<Page not opened>");
    }

    @Step(value = "Accept cookies. Check that form is closed")
    public static void acceptCookies() {
        cookieForm.acceptCookies();
        Assert.assertFalse(cookieForm.isCookiesFormExists(), "<Cookies form not closed>");
    }
}