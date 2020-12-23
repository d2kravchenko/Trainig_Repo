package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.steps.TimerBeginFromZeroTestSteps;

public class TimerBeginFromZeroTest extends  BaseTest{


    @Description(value = "The test checks that timer on page starts from 11:11:11 (test always fails because timer starts from zero)")
    @Link(name = "Userinyerface home page", url = "https://userinyerface.com/game.html%20target=")
    @Test(description = "Userinyerface - Timer test")
    public static void testTimer() {                 //This test must fail, timer start from 00:00:00 instead of 11:11:11
        TimerBeginFromZeroTestSteps.goToHomepage();
        TimerBeginFromZeroTestSteps.checkCounter();
    }
}