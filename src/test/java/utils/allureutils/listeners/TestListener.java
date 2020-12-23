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
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureHelper.attachScreenshot(AqualityServices.getBrowser().getScreenshot());
    }


    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName(); //Not sure what to attach to. To the name of a method, class, test name, or something else.
        ISettingsFile allureSettingFile = new JsonSettingsFile("allureData.json");
        Allure.description(allureSettingFile.getValue(String.format("/%s/Description", methodName)).toString());
        String link = allureSettingFile.getValue(String.format("/%s/Link", methodName)).toString();
        Allure.link(link);
    }
}
