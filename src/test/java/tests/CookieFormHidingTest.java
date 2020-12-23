package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.steps.CookieFormHidingTestSteps;

public class CookieFormHidingTest extends BaseTest {

    @Description(value = "The test checks that the cookie form successfully disappears from the page on closing")
    @Link(name = "Home page", value = "https://userinyerface.com/game.html%20target=")
    @Test(description = "Userinyerface - Cookie hiding test")
    public static void cookieFormHidingTest() {
        CookieFormHidingTestSteps.goToHomepage();
        CookieFormHidingTestSteps.acceptCookies();
    }
}