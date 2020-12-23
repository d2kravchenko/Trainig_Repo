package utils.allureutils.listeners;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.qameta.allure.Allure;
import utils.allureutils.AllureHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("GETTING SCREENSHOT");
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("GETTING SCREENSHOT");
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }
}
