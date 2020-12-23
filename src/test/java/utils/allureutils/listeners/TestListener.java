package utils.allureutils.listeners;

import utils.allureutils.AllureHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureHelper.attachScreenshot();
    }
    @Override
    public void onTestFailure(ITestResult result) {
        AllureHelper.attachScreenshot();
    }
}
