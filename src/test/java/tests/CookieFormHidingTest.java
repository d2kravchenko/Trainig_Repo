package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.steps.CookieFormHidingTestSteps;

public class CookieFormHidingTest {

    public static final String HOMEPAGE = "https://userinyerface.com/game.html%20target="; // Url in @Link must be constant

   // @Description(value = "The test checks that the cookie form successfully disappears from the page on closing")
  //  @Link(name = "Userinyerface home page", url = HOMEPAGE)
    @Test(description = "Userinyerface - Cookie hiding test")
    public static void cookieHidingTest() {
        CookieFormHidingTestSteps.goToHomepage();
        CookieFormHidingTestSteps.acceptCookies();
    }
}