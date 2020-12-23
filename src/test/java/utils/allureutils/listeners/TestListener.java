package utils.allureutils.listeners;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.qameta.allure.Allure;
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

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = Object.class.getEnclosingMethod().getName();
        System.out.println(methodName);
        ISettingsFile allureSettingFile = new JsonSettingsFile("allureData.json");
        Allure.description(allureSettingFile.getValue(String.format("/%s/Description", methodName)).toString());
        Allure.link("Homepage", allureSettingFile.getValue(String.format("/%s/Link", methodName)).toString());

    }
}
