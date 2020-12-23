package utils.allureutils.listeners;

import aquality.selenium.browser.AqualityServices;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.allureutils.AllureHelper;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }
}
