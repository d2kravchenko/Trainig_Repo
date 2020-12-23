package utils.allureutils.listeners;

import aquality.selenium.browser.AqualityServices;
import utils.allureutils.AllureHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }

    @Override
    public void onTestStart(ITestResult result) {
        AllureHelper.setAllureLinkAndDescription(result);
    }
}
