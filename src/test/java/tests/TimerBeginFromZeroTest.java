package tests;

import org.testng.annotations.Test;
import tests.steps.TimerBeginFromZeroTestSteps;

public class TimerBeginFromZeroTest extends BaseTest {

    @Test(description = "Userinyerface - Timer test")
    public static void timerBeginFromZeroTest() {                 //This test must fail, timer start from 00:00:00 instead of 11:11:11
        TimerBeginFromZeroTestSteps.goToHomepage();
        TimerBeginFromZeroTestSteps.checkCounter();
    }
}