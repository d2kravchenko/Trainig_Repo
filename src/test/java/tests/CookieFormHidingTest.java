package tests;

import org.testng.annotations.Test;
import tests.steps.CookieFormHidingTestSteps;

public class CookieFormHidingTest extends BaseTest {

    @Test(description = "Userinyerface - Cookie hiding test")
    public static void cookieFormHidingTest() {
        CookieFormHidingTestSteps.goToHomepage();
        CookieFormHidingTestSteps.acceptCookies();
    }
}